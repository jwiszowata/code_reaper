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
from .utils import similarity

from code_reaper.models import Function, Task, Achievement, Round, Game
import random
import numpy as np
import queue
import json

@login_required(login_url='/code_reaper/sign/')
def summarize_day(request):
    user = request.user
    if user.username == 'admin':
        funs = Function.objects.filter(status=Function.FINISHED)
        for fun in funs:
            criterion1 = Q(function=fun.pk)
            criterion2 = Q(status=Task.TRUSTED)
            tasks = Task.objects.filter(criterion1 & criterion2)
            if len(tasks) < 3:
                print("ERROR")
            else:
                results = []
                for task1 in tasks:
                    res = 0
                    for task2 in tasks:
                        if task1 != task2:
                            res += similarity(task1, task2, fun)
                    results += [res]
                winners = find_winners(results, tasks)
                for winner in winners:
                    try:
                        achievement = Achievement.objects.get(user=winner)
                    except Achievement.DoesNotExist:
                        achievement = Achievement(user=winner)
                    setattr(achievement, 'wheat', achievement.wheat + 1)
                    setattr(achievement, 'bonus_wheat', achievement.bonus_wheat + 1)
                    achievement.save()
            #setattr(fun, 'status', Function.DONE)
            #fun.save()
            print(fun)
            print(results)
            setattr(fun, 'status', Function.DONE)
            fun.save()
        return render(request, 'code_reaper/index.html')


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

def find_winners(results, tasks):
    max_result = max(results)
    winners = []
    for (task, result) in zip(tasks, results):
        if result == max_result:
            winners += [task.user]
    return winners
