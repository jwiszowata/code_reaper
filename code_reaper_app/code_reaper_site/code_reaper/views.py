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

from .models import Function, Task, Achievement, Round, Game
import random
import numpy as np
import queue
import json


# def choose_game(request):
#     return render(request, 'code_reaper/game.html')

@login_required(login_url='/code_reaper/sign/')
def games(request):
    user = request.user
    try:
        achievement = Achievement.objects.get(user=user)
        wheat = achievement.wheat
    except Achievement.DoesNotExist:
        achievement = Achievement(user=user)
        achievement.save()
        wheat = 1

    games_count = Game.objects.filter().count()
    games = [{'nr': i, 
              'result': '?', 
              'cost': [1]
              } for i in range(1, games_count + 1)]

    rounds = Round.objects.filter(user=user)
    user_games = [{'nr': r.game.number, 
                   'result': r.best_result, 
                   'cost': range(min(3, r.times + 1))
                   } for r in rounds]

    for game in user_games:
        games[game['nr'] - 1] = game

    context = {
        'games': games,
        # [{'nr':1,'result':45, 'cost':[1]},{'nr':2,'result':'?', 'cost':[1,1]},{'nr':3,'result':5, 'cost':[1,1]},{'nr':4,'result':56, 'cost':[1]},{'nr':5,'result':13, 'cost':[1]},{'nr':6,'result':45, 'cost':[1,1,1]},{'nr':7,'result':45, 'cost':[1,1]},{'nr':8,'result':45, 'cost':[1,1,1]},{'nr':9,'result':45, 'cost':[1,1,1]},{'nr':10,'result':45, 'cost':[1,1,1]},{'nr':11,'result':45, 'cost':[1,1,1]},{'nr':12,'result':45, 'cost':[1,1,1]},{'nr':13,'result':45, 'cost':[1,1,1]},{'nr':14,'result':45, 'cost':[1,1,1]},{'nr':15,'result':45, 'cost':[1,1,1]},{'nr':16,'result':45, 'cost':[1,1,1]}],
        'wheat': wheat
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

    rounds = Round.objects.exclude(best_result__isnull=True).order_by('best_result')

    games = [[] for i in range(16)]
    for r in rounds:
        rank = count_rank(games[r.game.number - 1], r)
        games[r.game.number - 1] += [{'username': r.user.username, 'result': r.best_result, 'rank': rank}]

    games_ranking = []
    for i, game in enumerate(games):
        games_ranking += [{'nr': i + 1, 'users': game}]
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
    context = {'code_ranking': users, 'games_ranking': games_ranking}
    return render(request, 'code_reaper/ranking.html', context)

def count_rank(ranking, record):
    if ranking != []:
        last = ranking[-1]
        # print(last)
        if record.best_result == last['result']:
            return last['rank']
        else:
            return last['rank'] + 1
    else:
        return 1

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
    return render(request, 'code_reaper/user.html')

############################## TASK ############################################

@login_required(login_url='/code_reaper/sign/')
def task(request):
    user = request.user   
    funs = funs_for_user(user)

    if funs != []:
        function_id = random.choices(funs, k=1)[0]
        function = Function.objects.get(pk=function_id)
    else:
        function = Function.objects.filter(status != FINISHED).first()

    print(function.times_done)
    context = {'function': function, 'next': (int(10) + 1) % 31}
    return render(request, 'code_reaper/task.html', context)

def funs_for_user(user):
    try:
        achievement = Achievement.objects.get(user=user)
        level = achievement.level
    except Achievement.DoesNotExist:
        achievement = Achievement(user=user)
        level = 1

    print("User status")
    print(achievement.status)
    if achievement.status == Achievement.TRUSTED:
        i = 0
    else:
        i = 2

    funs = []
    while len(funs) < 3:
        funs += get_proper_functions_for_user(user, level, i)
        if achievement.status == Achievement.TRUSTED:
            i += 1
        else:
            i -= 1
    return funs

def get_proper_functions_for_user(user, level, times):
    min_d = 10 * (level - 1)
    max_d = 10 * level

    criterion1 = Q(difficulty__lt=max_d)
    criterion2 = Q(difficulty__gte=min_d)
    criterion3 = Q(times_done=times)
    funs_of_level_pk = Function.objects.filter(criterion1 & criterion2 & criterion3).values_list('pk', flat=True)
    
    done_tasks_of_level = Task.objects.filter(user=user, function__in=funs_of_level_pk)
    done_funs = [task.function for task in done_tasks_of_level]
    return diff(funs_of_level_pk, done_funs)

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

        points = function.difficulty
        got_level = False
        level = 1
        got_wheat = 1
        try:
            achievement = Achievement.objects.get(user=user)
            points = achievement.points + function.difficulty;
            setattr(achievement, 'points', points)
            curr_level = achievement.level
            level = curr_level
            if (points >= points_max(curr_level)):
                got_level = True
                level = curr_level + 1
                got_wheat = curr_level + 2
                setattr(achievement, 'level', level)
                setattr(achievement, 'wheat', achievement.wheat + got_wheat)
            achievement.save()
        except Achievement.DoesNotExist:
            achievement = Achievement(user=user, points=function.difficulty, level=1, wheat=1)
            achievement.save()
        return HttpResponse(json.dumps({
                'got_points': function.difficulty,
                'all_points': points,
                'got_level': got_level,
                'level': level,
                'wheat': got_wheat,
                'to_next_level': points_max(level) - points }),
                content_type="application/json")
    #HttpResponseRedirect(reverse('task', args=(function.lines_nr+1,)))

def points_max(level):
    return 10 * level * (level + 1)

############################ GAME ##############################################

@login_required(login_url='/code_reaper/sign/')
def game(request):
    if request.method == 'POST':
        game_nr = request.POST['nr']
        get_tax(request.user, game_nr)
        game = Game.objects.get(number=game_nr)
        random.seed(a=game.seed)
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
                    'done': False,
                    'active': False
                }
        fields[0]['done'] = True
        fields[0]['active'] = True

        context = {
        'size': size,
        'fields': fields,
        'colors': colors
        }
        updatedBoard = updateBoard(fields, size, fields[0]['color'])
        request.session['game'] = game.pk
        request.session['size'] = size
        request.session['fields'] = updatedBoard['board']
        request.session['colors'] = colors
        request.session['steps'] = 0
        request.session['done'] = updatedBoard['done']
        return render(request, 'code_reaper/game.html', context)

def get_tax(user, game_nr):
    game = Game.objects.get(number=game_nr)
    times = 0
    try:
        r = Round.objects.get(user=user, game=game)
        times = r.times
    except Round.DoesNotExist:
        r = Round(user=user, game=game, times=0)

    cost = min(3, times + 1)

    try:
        achievement = Achievement.objects.get(user=user)
    except Achievement.DoesNotExist:
        achievement = Achievement(user=user, points=0, level=1, wheat=1)
        achievement.save()

    if achievement.wheat >= cost:
        wheat = achievement.wheat - cost
        setattr(achievement, 'wheat', wheat)
        achievement.save()

        setattr(r, 'times', times + 1)
        r.save()

@login_required(login_url='/code_reaper/sign/')
def make_move(request):
    if request.method == 'GET':

        steps = request.session['steps'] + 1
        size = request.session['size']
        color = int(request.GET.get("color"))
        finished = False

        if color in request.session['colors']:
            updatedBoard = updateBoard(request.session['fields'], 
                request.session['size'], color)
            fields = updatedBoard['board']
            done = updatedBoard['done']
            print(done)
            if done == size * size:
                finished = True
                user = request.user
                game = int(request.session['game'])
                r = Round.objects.get(user=user, game=game)
                if r.best_result:
                    setattr(r, 'best_result', min(steps, r.best_result))
                else:
                    setattr(r, 'best_result', steps)
                r.save()

            request.session['steps'] = steps
            request.session['fields'] = fields
            request.session['done'] = done

        else:
            fields = []
        return HttpResponse(json.dumps({
                'fields': fields,
                'steps': steps,
                'finished': finished }),
                content_type="application/json")

def updateBoard(fields, size, color):
    board = np.asarray(fields).reshape((size, size))
    #b = board[2,0]
    #print("Rownosc: 2 == ", b["row"]," 0 == ", b["column"])
    vis = np.asarray([False] * size * size).reshape((size, size))
    colorizedBoard = colorizeDone(board, size, color)
    board = colorizedBoard['board']
    done = colorizedBoard['done']
    q = getActiveQueue(board, size) 
    while q.empty() == False:
        f = q.get()
        fRow = f["row"]
        fCol = f["column"]
        vis[fRow, fCol] = True
        active = 0
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
            if c in range(size) and r in range(size):
                active += 1
                if board[r, c]['done']:
                    board[r, c]['color'] = color
                    active -= 1
                else:
                    if board[r, c]['color'] == color:
                        board[r, c]['done'] = True
                        done += 1
                        board[r, c]['active'] = True
                        active -= 1
                        if vis[r, c] == False:
                            q.put(board[r, c])
        if active == 0:
            board[fRow, fCol]['active'] = False
                    
    return { 'board': board.reshape((1, size * size)).tolist()[0],
             'done': done }

def colorizeDone(board, size, color):
    done = 0
    for r in range(size):
        for c in range(size):
            if board[r,c]['done']:
                board[r,c]['color'] = color
                done += 1
    return {'board': board, 'done': done }

def getActiveQueue(board, size):
    q = queue.Queue()
    for r in range(size):
        for c in range(size):
            if board[r, c]['active']:
                q.put(board[r, c])
    return q

# def wypisz(t, s):
#     for i in range(s):
#         res = ""
#         for j in range(s):
#             res = res + "%r " % (t[i,j])
#         print(res)
