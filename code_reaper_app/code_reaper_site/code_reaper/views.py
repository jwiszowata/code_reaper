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

from .models import Function, Task, Achievement
import random
import numpy as np
import queue
import json


def choose_game(request):
    return render(request, 'code_reaper/game.html')

@login_required(login_url='/code_reaper/sign/')
def games(request):
    context = {
        'games': [{'nr':1,'result':45, 'cost':[1]},{'nr':2,'result':'?', 'cost':[1,1]},{'nr':3,'result':5, 'cost':[1,1]},{'nr':4,'result':56, 'cost':[1]},{'nr':5,'result':13, 'cost':[1]},{'nr':6,'result':45, 'cost':[1,1,1]},{'nr':7,'result':45, 'cost':[1,1]},{'nr':8,'result':45, 'cost':[1,1,1]},{'nr':9,'result':45, 'cost':[1,1,1]},{'nr':10,'result':45, 'cost':[1,1,1]},{'nr':11,'result':45, 'cost':[1,1,1]},{'nr':12,'result':45, 'cost':[1,1,1]},{'nr':13,'result':45, 'cost':[1,1,1]},{'nr':14,'result':45, 'cost':[1,1,1]},{'nr':15,'result':45, 'cost':[1,1,1]},{'nr':16,'result':45, 'cost':[1,1,1]}],
        'grain': 10
    }
    return render(request, 'code_reaper/games.html', context)

def ranking(request):
    achievements = Achievement.objects.filter().order_by('-points')
    # users = User.objects.filter()
    #users_id_sorted = [achievement.user.username for achievement in achievements]
    # users_dict = dict([(u.pk, u.username) for u in users])
    # print(users_dict)
    # print(users_id_sorted)
    # sorted_usernames = [users_dict[id] for id in users_id_sorted]
    # print(sorted_usernames)

    users = []
    max_of_points = achievements[0].points
    for i, achievement in enumerate(achievements):
        users += [{
            'username': achievement.user.username,
            'rank': i + 1,
            'level': achievement.level,
            'points': round((achievement.points/max_of_points) * 100)
        }]

    # ranking = Task.objects.values('user').annotate(tasks=Count('user')).order_by('-tasks')
    # users = []
    # all_tasks = 0

    # for rank in ranking:
    #     all_tasks = max(all_tasks, rank['tasks'])

    # for i, rank in enumerate(achievements):
    #     userId = rank['user']
    #     username = User.objects.get(pk=userId).username
    #     tasks = rank['tasks']
    #     user = {
    #         'username': username, 
    #         'rank': i + 1, 
    #         'tasks': tasks, 
    #         'points': round((tasks/all_tasks) * 100)
    #     }
    #     users += [user]
    context = {'users': users}
    return render(request, 'code_reaper/ranking.html', context)

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
            return render(request, 'code_reaper/user.html')
    else:
        form = UserCreationForm()
    return render(request, 'code_reaper/sign.html', {'form': form})

def sign(request):
    if request.GET:  
        next_url = request.GET['next']
        context = {'next': next_url}
    return render(request, 'code_reaper/sign.html', context)

@login_required(login_url='/code_reaper/sign/')
def user(request):
    return render(request, 'code_reaper/user.html')

############################## TASK ############################################

@login_required(login_url='/code_reaper/sign/')
def task(request, function_length):
    user = request.user
    try:
        achievement = Achievement.objects.get(user=user)
        level = achievement.level
    except Achievement.DoesNotExist:
        achievement = Achievement(user=user)
        level = 1

    min_d = 10 * (level - 1)
    max_d = 10 * level
    
    criterion1 = Q(difficulty__lt=max_d)
    criterion2 = Q(difficulty__gte=min_d)
    funs_of_level_pk = Function.objects.filter(criterion1 & criterion2).values_list('pk', flat=True)
    done_tasks_of_level = Task.objects.filter(user=user, function__in=funs_of_level_pk)
    done_funs = [task.function for task in done_tasks_of_level]
    funs = diff(funs_of_level_pk, done_funs)

    function_id = random.choices(funs, k=1)[0]
    function = Function.objects.get(pk=function_id)

    context = {'function': function, 'next': (int(function_length) + 1) % 31}
    return render(request, 'code_reaper/task.html', context)

def diff(first, second):
        second = set(second)
        return [item for item in first if item not in second]

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
        task = Task(function=function, user=user, time=time, grayed_out_lines=grayed_out_lines)
        task.save()

        try:
            achievement = Achievement.objects.get(user=user)
            points = achievement.points + function.difficulty;
            setattr(achievement, 'points', points)
            curr_level = achievement.level
            if (points > points_max(curr_level)):
                setattr(achievement, 'level', curr_level + 1)
                setattr(achievement, 'wheat', achievement.wheat + curr_level + 2)
            achievement.save()
        except Achievement.DoesNotExist:
            achievement = Achievement(user=user, points=function.difficulty, level=1, wheat=1)
            achievement.save()
    return HttpResponseRedirect(reverse('task', args=(function.lines_nr+1,)))

def points_max(level):
    return 10 * level * (level + 1)

############################ GAME ##############################################

@login_required(login_url='/code_reaper/sign/')
def game(request):
    random.seed(a=2034)
    size = 15;
    colors = [1, 2, 3, 4, 5, 6]
    fields_colors = random.choices(colors, k=size*size)
    fields = [{}] * (size * size)
    for c in range(size):
        for r in range(size):
            cell = c + r * size;
            fields[cell] = { 
                'color': fields_colors[cell],
                'row': r,
                'column': c,
                'done': False
            }
    fields[0]['done'] = True

    context = {
    'size': size,
    'fields': fields,
    'colors': colors
    }
    request.session['size'] = size
    request.session['fields'] = fields
    request.session['colors'] = colors
    request.session['steps'] = 0
    return render(request, 'code_reaper/game.html', context)

@login_required(login_url='/code_reaper/sign/')
def make_move(request):
    if request.method == 'GET':
        request.session["steps"] = request.session["steps"] + 1
        color = int(request.GET.get("color"))
        if color in request.session['colors']:
            fields = updateBoard(request.session['fields'], 
                request.session['size'], color)
            request.session['fields'] = fields
        else:
            fields = []
        return HttpResponse(json.dumps({
                "fields": fields,
                "steps": request.session["steps"]}),
                content_type="application/json")

def updateBoard(fields, size, color):
    board = np.asarray(fields).reshape((size, size))
    b = board[2,0]
    print("Rownosc: 2 == ", b["row"]," 0 == ", b["column"])
    vis = np.asarray([False] * size * size).reshape((size, size))
    q = queue.Queue()
    q.put(board[0, 0])
    #print(queue)
    while q.empty() == False:
        print(q)
        f = q.get()
        fRow = f["row"]
        fCol = f["column"]
        #print("sprawdzamy", fRow, fCol)
        vis[fRow,fCol] = True
        #print(fRow, fCol)
        edges = [
            [fRow, fCol],
            [fRow + 1, fCol],
            [fRow, fCol - 1],
            [fRow - 1, fCol],
            [fRow, fCol + 1]
        ]
        for e in edges:
            r = e[0]
            c = e[1]
            #print("(" + r +", " +c +")")
            if c in range(size) and r in range(size):
                print(r, c, board[r, c]['done'], board[r, c]['color'])
                if board[r, c]['done'] or board[r, c]['color'] == color:
                    board[r, c]['color'] = color
                    board[r, c]['done'] = True
                    if vis[r, c] == False:
                        q.put(board[r, c])
                    #print(r, c)
        #wypisz(vis, 5)
    return board.reshape((1, size * size)).tolist()[0]


def wypisz(t, s):
    for i in range(s):
        res = ""
        for j in range(s):
            res = res + "%r " % (t[i,j])
        print(res)
