from django.shortcuts import get_object_or_404, render
from django.http import HttpResponseRedirect, HttpResponse
from django.urls import reverse
from django.contrib.auth import authenticate, login, logout
from django.contrib.auth.forms import UserCreationForm, AuthenticationForm
from django.shortcuts import render, redirect
from django.contrib.auth.decorators import login_required
from django.db.models import Count
from django.contrib.auth.models import User
from django.db.models import Q

from code_reaper.models import Function, Task, Achievement, Round, Game, Package
from .views_ranking import getReaperRanking, getWheaterRanking, getPlayerRanking
import random
import numpy as np
import queue
import json
import math

############################ MAIN ##############################################

def index(request):
    all_functions = Function.objects.filter().count()
    done_functions = Function.objects.filter(status=Function.DONE).count()
    print("done_functions", done_functions)
    print("all_functions", all_functions)
    context = {
        'all': all_functions,
        'done': done_functions,
        'percent': math.ceil(done_functions/all_functions)
    }
    return render(request, 'code_reaper/index.html', context)

############################ USER ##############################################

def logout_view(request):
    logout(request)
    return redirect('index')

def signup_view(request):
    print("signup_view")
    if request.method == 'POST':
        print("signup_view: POST")
        sign_form = UserCreationForm(request.POST)
        if sign_form.is_valid():
            print("signup_view: valid")
            user = sign_form.save()
            login(request, user, backend='django.contrib.auth.backends.ModelBackend')
            return redirect('user')
    else:
        sign_form = UserCreationForm()
    login_form = AuthenticationForm()
    context = {'sign_form': sign_form, 
               'login_form': login_form, 
               'sign_active': "show active"
               }
    return render(request, 'registration/login.html', context)

def sign(request):
    if request.GET:  
        next_url = request.GET['next']
    else:
        next_url = ""
    sign_form = UserCreationForm()
    login_form = AuthenticationForm()
    print(login_form)
    context = {'next': next_url, 
                'sign_form': sign_form, 
                'login_form': login_form
                }
    return render(request, 'registration/login.html', context)

def login_view(request):
    print("login")
    if request.POST:
        username = request.POST['username']
        password = request.POST['password']
        user = authenticate(request, username=username, password=password)
        print("login", user)
        if user is not None:
            login(request, user, backend='django.contrib.auth.backends.ModelBackend')
            return redirect('user')
        else:
            err_message = "Wrong username or password."
    else:
        err_message = "Not a POST request!"
    sign_form = UserCreationForm()
    login_form = AuthenticationForm()
    context = {'sign_form': sign_form, 
            'login_form': login_form, 
            'login_error': err_message
            }
    return render(request, 'registration/login.html', context)

@login_required(login_url='/code_reaper/sign/')
def user(request):
    user = request.user
    try:
        achievement = Achievement.objects.get(user=user)
    except Achievement.DoesNotExist:
        achievement = Achievement(user=user)
    username = user.username
    points = achievement.points
    level = achievement.level
    wheat = achievement.wheat
    factor = achievement.factor

    task_statuses = Task.objects.filter(user=user).values_list('status', flat=True)
    best = 0
    waiting = 0
    trusted = 0
    notTrusted = 0
    for status in task_statuses:
        if status == Task.BEST:
            best += 1
        if status == Task.WAITING:
            waiting += 1
        if status == Task.TRUSTED:
            trusted += 1
        if status == Task.NOT_TRUSTED:
            notTrusted += 1

    print(best, waiting, trusted, notTrusted, len(task_statuses), best + waiting + trusted + notTrusted)
    package_statuses = Package.objects.filter(user=user).values_list('status', flat=True)
    package_pos = 0
    package_neg = 0
    for s in package_statuses:
        if s == Package.TRUSTED:
            package_pos += 1
        if s == Package.NOT_TRUSTED:
            package_neg += 1

    context = { 
        'username': username, 
        'statistics': {
            'wheat': wheat, 
            'level': level, 
            'points': points,
            'factor': round(factor, 2),
            'package_pos': package_pos,
            'package_neg': package_neg
        },
        'tasks': taskObj(len(task_statuses), best, trusted - best, notTrusted, waiting),  
        'wheater': getRank(user.username, getWheaterRanking()),
        'reaper': getRank(user.username, getReaperRanking()), 
        'games': getGameRank(user.username)
    }
    return render(request, 'code_reaper/user.html', context)


def getRank(username, ranking):
    for r in ranking:
        if r['username'] == username:
            return r['rank']

def getGameRank(username):
    games = getPlayerRanking()
    res = []
    for game in games:
        for user in game['users']:
            if user['username'] == username:
                res += [{'nr': game['nr'], 'rank': user['rank']}]
                break
    return res

def taskObj(tasks, best, pos, neg, wait):
    half = tasks / 2
    return { 
        'all': tasks,
        'best1': f(best, half),
        'best2': s(best, half),
        'positive1': f(pos, half),
        'positive2': s(pos, half),
        'negative1': f(neg, half),
        'negative2': s(neg, half),
        'waiting1': f(wait, half),
        'waiting2': s(wait, half)
    }

def f(x, y):
    if y == 0:
        return 0
    if divmod(x, y)[0] > 1:
        return y
    else:
        return divmod(x, y)[0] * y

def s(x, y):
    if y == 0:
        return 0
    if divmod(x, y)[0] > 1:
        return y
    else:
        return divmod(x, y)[1]