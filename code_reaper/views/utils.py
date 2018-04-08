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
from math import floor

from code_reaper.models import Function, Task, Achievement, Round, Game, Package
import random
import numpy as np
import queue
import json

######################### createNewPackage #####################################

def createNewPackage(user):
    funs = funs_for_user(user)
    print("Received "+str(len(funs))+" for user " + user.username)
    if len(funs) < 3:
        print("Only "+str(len(funs))+" functions received")
        funs = funs * 3
    trusted = find_trusted(funs)
    funs.remove(trusted)
    rf = get_random_functions(funs, 2)
    functions = [trusted] + rf
    setFunctionsIdAs(functions, Function.PENDING, False)
    r = random.sample(functions, 3)

    package = Package(
        user=user, 
        function1=Function.objects.get(pk=r[0]), 
        function2=Function.objects.get(pk=r[1]), 
        function3=Function.objects.get(pk=r[2]), 
        checking_function=r.index(trusted), 
        status=Package.PENDING)
    package.save()
    print(package)
    return package

################################## funs_for_user ###############################

def funs_for_user(user):
    try:
        achievement = Achievement.objects.get(user=user)
        level = achievement.level
    except Achievement.DoesNotExist:
        achievement = Achievement(user=user)
        level = 1
    if achievement.status == Achievement.TRUSTED:
        i = 0
    else:
        i = 2
    funs = []
    for status in [Function.READY, Function.PENDING, Function.FINISHED]:
        if len(funs) < 3:
            while len(funs) < 3 and (i >= 0 and i <= 3):
                funs += get_proper_functions_for_user(user, level, i, status)
                if achievement.status == Achievement.TRUSTED:
                    i += 1
                else:
                    i -= 1
    if len(funs) < 3:
        print("UWAGA PROBLEM!!! ZA MAŁO FUNKCJI!!!")
        funs = get_proper_functions_for_user(user, 21, 0, Function.READY)
    return funs

def get_proper_functions_for_user(user, level, times, status):
    if level <= 20:
        criterion1 = Q(level=level)
        criterion2 = Q(times_done=times)
        criterion3 = Q(status=status)
        funs_of_level_pk = Function.objects.filter(criterion1 & criterion2 & criterion3).values_list('pk', flat=True)
    else:
        funs_of_level_pk = Function.objects.filter().values_list('pk', flat=True)
    done_tasks_of_level = Task.objects.filter(user=user)
    done_funs = [task.function for task in done_tasks_of_level]
    return diff(funs_of_level_pk, done_funs)

def diff(first, second):
        second = set(second)
        return [item for item in first if item not in second]

################################################################################

def find_trusted(funs):
    for fun in funs:
        tasks = Task.objects.filter(function=fun, status=Task.TRUSTED)
        if tasks:
            return fun
    return funs[0]

def get_random_functions(funs, nr):
    function_ids = random.sample(funs, k=nr)
    return function_ids

def setFunctionsIdAs(funs, status, inc):
    for fun in funs:
        function = Function.objects.get(pk=fun)
        setattr(function, 'status', status)
        if inc:
            setattr(function, 'times_done', function.times_done + 1)
            if function.times_done >= 3:
                setattr(function, 'status', Function.FINISHED)
        function.save()

################################################################################

def similarity(task1, task2, function):
    print(task2, "task 2")
    lines_nr = function.lines_nr
    lines1 = marked_removed(lines_nr, task1.grayed_out_lines)
    lines2 = marked_removed(lines_nr, task2.grayed_out_lines)

    res = 0
    for (l1, l2) in zip(lines1, lines2):
        if l1 == l2:
            res += 1
    print(lines1)
    print(lines2)
    print(res / lines_nr)
    return res / lines_nr

def marked_removed(lines_nr, removed_lines):
    removed = unfold_string_list(removed_lines)
    lines = [1] * lines_nr
    for r in removed:
        lines[r - 1] = 0
    return lines

def unfold_string_list(s):
    if s:
        l = [int(x) for x in s.split(',')]
        return l
    else:
        return []