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

def ranking(request):
    context = {
        'code_ranking': getReaperRanking(), 
        'games_ranking': getPlayerRanking(),
        'wheat_ranking': getWheaterRanking()
    }
    return render(request, 'code_reaper/ranking.html', context)

def getReaperRanking():
    achievements = Achievement.objects.filter().order_by('-points')
    users = []
    if achievements.exists():
        max_of_points = achievements[0].points
        for i, achievement in enumerate(achievements):
            users += [{
                'username': achievement.user.username,
                'rank': i + 1,
                'level': achievement.level,
                'points': achievement.points,
                'points_stat': round((achievement.points/max_of_points) * 100)
            }]
    return users

def getWheaterRanking():
    achievements = Achievement.objects.filter().order_by('-gained_wheat')
    wheaters = []
    if achievements.exists():
        max_of_wheats = max(achievements[0].gained_wheat, 1)
        for i, achievement in enumerate(achievements):
            wheaters += [{
                'username': achievement.user.username,
                'rank': i + 1,
                'wheats': achievement.gained_wheat,
                'wheat_stat': round((achievement.gained_wheat/max_of_wheats) * 100)
            }]
    return wheaters

def getPlayerRanking():
    rounds = Round.objects.exclude(best_result__isnull=True).order_by('best_result')

    games = [[] for i in range(16)]
    for r in rounds:
        rank = count_rank(games[r.game.number - 1], r)
        games[r.game.number - 1] += [{'username': r.user.username, 'result': r.best_result, 'rank': rank}]

    games_ranking = []
    for i, game in enumerate(games):
        games_ranking += [{'nr': i + 1, 'users': game}]

    return games_ranking

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