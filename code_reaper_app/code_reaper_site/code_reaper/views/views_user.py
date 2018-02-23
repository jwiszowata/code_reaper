from django.shortcuts import get_object_or_404, render
from django.http import HttpResponseRedirect, HttpResponse
from django.urls import reverse
from django.contrib.auth import authenticate, login, logout
from django.contrib.auth.forms import UserCreationForm
from django.shortcuts import render, redirect
from django.contrib.auth.decorators import login_required
from django.db.models import Count
from django.contrib.auth.models import User
from django.db.models import Q

from code_reaper.models import Function, Task, Achievement, Round, Game
import random
import numpy as np
import queue
import json

############################ MAIN ##############################################

def index(request):
    return render(request, 'code_reaper/index.html')

############################ USER ##############################################

def logout_view(request):
    logout(request)
    return render(request, 'code_reaper/index.html')

def signup_view(request):
    if request.method == 'POST':
        form = UserCreationForm(request.POST)
        if form.is_valid():
            user = form.save()
            login(request, user)
            return render(request, 'code_reaper/index.html')
    else:
        form = UserCreationForm()
    return render(request, 'registration/login.html', {'form': form})

def sign(request):
    if request.GET:  
        next_url = request.GET['next']
        context = {'next': next_url}
    return render(request, 'code_reaper/sign.html', context)

@login_required(login_url='/code_reaper/sign/')
def user(request):
    print("I am a user")
    games = [1,2,3,4,5,6,7,8,9,1,2,3,1,3,4,8]
    context = {'reaper': 10, 'player': 45, 'username': 'admin', 'wheat': 10, 
    'games': games, 'level': 5, 'points': 5746, 'wheater': 5, 'factor': 1.4, 'tasks':8,
    'best': 2, 'positive': 1, 'negative': 2, 'waiting': 3, 'package_pos': 10, 'package_neg': 7}
    return render(request, 'code_reaper/user.html', context)


