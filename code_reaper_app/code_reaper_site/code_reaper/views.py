from django.shortcuts import get_object_or_404, render
from django.http import HttpResponseRedirect, HttpResponse
from django.urls import reverse
from django.contrib.auth import authenticate, login, logout
from django.contrib.auth.forms import UserCreationForm
from django.shortcuts import render, redirect
from django.contrib.auth.decorators import login_required
from django.db.models import Count
from django.contrib.auth.models import User

from .models import Function, Task
import random
import numpy as np
import queue
import json


def choose_game(request):
    return render(request, 'code_reaper/game.html')

def games(request):
    context = {
        'games': [{'nr':1,'result':45, 'cost':[1]},{'nr':2,'result':'?', 'cost':[1,1]},{'nr':3,'result':5, 'cost':[1,1]},{'nr':4,'result':56, 'cost':[1]},{'nr':5,'result':13, 'cost':[1]},{'nr':6,'result':45, 'cost':[1,1,1]},{'nr':7,'result':45, 'cost':[1,1]},{'nr':8,'result':45, 'cost':[1,1,1]},{'nr':9,'result':45, 'cost':[1,1,1]},{'nr':10,'result':45, 'cost':[1,1,1]},{'nr':11,'result':45, 'cost':[1,1,1]},{'nr':12,'result':45, 'cost':[1,1,1]},{'nr':13,'result':45, 'cost':[1,1,1]},{'nr':14,'result':45, 'cost':[1,1,1]},{'nr':15,'result':45, 'cost':[1,1,1]},{'nr':16,'result':45, 'cost':[1,1,1]}],
        'grain': 10
    }
    return render(request, 'code_reaper/games.html', context)

def ranking(request):
    ranking = Task.objects.values('user').annotate(tasks=Count('user')).order_by('-tasks')
    users = []
    all_tasks = 0

    for rank in ranking:
        all_tasks = max(all_tasks, rank['tasks'])

    for i, rank in enumerate(ranking):
        userId = rank['user']
        username = User.objects.get(pk=userId).username
        tasks = rank['tasks']
        user = {
            'username': username, 
            'rank': i + 1, 
            'tasks': tasks, 
            'points': round((tasks/all_tasks) * 100)
        }
        users += [user]
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
    function = Function.objects.filter(lines_nr=function_length).first()
    context = {'function': function, 'next': (int(function_length) + 1) % 31}
    return render(request, 'code_reaper/task.html', context)

@login_required(login_url='/code_reaper/sign/')
def gray_out(request, function_id):
    if request.method == 'POST':
        function = get_object_or_404(Function, pk=function_id)
        user = request.user
        time = request.POST['time']
        print("time " + time)
        res = []
        for i in range(1, function.lines_nr + 1):
            try:
                request.POST['line' + str(i)]
            except:
                #print("no " + str(i))
                res += [str(i)]
        print(res)
        grayed_out_lines = ','.join(res);
        print(grayed_out_lines)
        t = Task(function=function, user=user, time=time, grayed_out_lines=grayed_out_lines)
        t.save()
    return HttpResponseRedirect(reverse('task', args=(function.lines_nr+1,)))

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
