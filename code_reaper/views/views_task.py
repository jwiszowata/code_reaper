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
from .utils import createNewPackage, similarity
from math import floor

from code_reaper.models import Function, Task, Achievement, Round, Game, Package
import random
import numpy as np
import queue
import json

@login_required(login_url='/code_reaper/sign/')
def task(request):
    user = request.user
    try:
        package = Package.objects.get(user=user, status=Package.PENDING)
    except Package.DoesNotExist:
        package = createNewPackage(user)
    function = getNotDoneFunction(package)
    if function:
        context = {'function': function}
        return render(request, 'code_reaper/task.html', context)
    else:
        return redirect('index')

def getNotDoneFunction(package):
    if not package.task1:
        return package.function1
    else:
        if not package.task2:
            return package.function2
        else:
            if not package.task3:
                return package.function3
            else:
                makePackageDone(package)
                return 0

def makePackageDone(package):
    summarizePackage(package)
    try:
        achievement = Achievement.objects.get(user=package.user)
    except Achievement.DoesNotExist:
        achievement = Achievement(user=package.user)
    if package.status == Package.TRUSTED:
        setattr(achievement, 'factor', achievement.factor * 1.1)
        setattr(achievement, 'bonus_wheat', achievement.bonus_wheat + 1)
    else:
        setattr(achievement, 'factor', achievement.factor * 0.9)
    achievement.save()

def summarizePackage(package):
    print("package", package.task1, package.task2, package.task3)
    if package.checking_function == 0:
        f = package.function1
        t = package.task1
    if package.checking_function == 1:
        f = package.function2
        t = package.task2
    if package.checking_function == 2:
        f = package.function3
        t = package.task3

    try:
        task = Task.objects.filter(status=Task.TRUSTED, function=f)[0]
    except IndexError:
        task = Task.objects.filter()[0]
    s = similarity(task, t, f)
    funs = [package.function1, package.function2, package.function3]
    tasks = [package.task1, package.task2, package.task3]
    if s > 0.6:
        setattr(package, 'status', Package.TRUSTED)
        setFunctionsObjAs(funs, Function.READY, True)
        set_task_as(tasks, Task.TRUSTED)

    else:
        setattr(package, 'status', Package.NOT_TRUSTED)
        setFunctionsObjAs(funs, Function.READY, False)
        set_task_as(tasks, Task.NOT_TRUSTED)
    package.save()
    print("summarizePackage", package.status)



def setFunctionsObjAs(funs, status, inc):
    for function in funs:
        setattr(function, 'status', status)
        if inc:
            setattr(function, 'times_done', function.times_done + 1)
            if function.times_done >= 3:
                setattr(function, 'status', Function.FINISHED)
        function.save()

def set_task_as(tasks, status):
    for task in tasks:
        #task = Task.objects.get(pk=t)
        setattr(task, 'status', status)
        task.save()


@login_required(login_url='/code_reaper/sign/')
def gray_out(request, function_id):
    if request.method == 'POST':
        function = get_object_or_404(Function, pk=function_id)
        user = request.user
        time = request.POST['time']
        lines = []
        for i in range(1, function.lines_nr + 1):
            try:
                request.POST['line' + str(i)]
            except:
                lines += [str(i)]
        grayed_out_lines = ','.join(lines);
        task = Task(function=function, user=user, time=time, grayed_out_lines=grayed_out_lines, status=Task.WAITING)
        task.save()

        package = Package.objects.get(user=user, status=Package.PENDING)
        if function == package.function1:
            setattr(package, 'task1', task)
        if function == package.function2:
            setattr(package, 'task2', task)
        if function == package.function3:
            setattr(package, 'task3', task)
        if package.task1 and package.task2 and package.task3:
            makePackageDone(package)
        package.save()

        points = function.difficulty
        got_level = False
        level = 1
        got_wheat = 1

        try:
            achievement = Achievement.objects.get(user=user)
            got_points = floor(achievement.factor * function.difficulty)
            points = achievement.points + got_points;
            setattr(achievement, 'points', points)
            curr_level = achievement.level
            level = curr_level
            if (points >= points_max(curr_level)):
                got_level = True
                print("got_level", points, points_max(curr_level))
                level = curr_level + 1
                got_wheat = floor(achievement.factor * (curr_level + 2))
                setattr(achievement, 'level', level)
                setattr(achievement, 'wheat', achievement.wheat + got_wheat)
                setattr(achievement, 'gained_wheat', achievement.gained_wheat + got_wheat)
            achievement.save()
        except Achievement.DoesNotExist:
            achievement = Achievement(user=user, points=function.difficulty, level=1, wheat=1)
            achievement.save()
        return HttpResponse(json.dumps({
                'got_points': got_points,
                'all_points': points,
                'got_level': got_level,
                'level': level,
                'wheat': got_wheat,
                'to_next_level': points_max(level) - points }),
                content_type="application/json")
    

# 4 times the average value of difficulty for functions of level
def points_max(level):
    pointsToGot = [0, 240, 368, 464, 552, 636, 704, 776, 852, 944, 1024, 1096, 
                        1168, 1232, 1308, 1380, 1440, 1504, 1552, 1616, 1696]
    s = [0] * 21
    for i, p in enumerate(pointsToGot):
        if i > 0:
            s[i] = s[i-1] + p
    if level > 20:
        return s[20] + (level - 20) * pointsToGot[20]
    else:
        return s[level]
    # diff = Function.objects.filter(level=level).values_list('difficulty', flat=True)
    # if len(diff) == 0:
    #     return 100
    # return 4 * round(sum(diff) / len(diff))