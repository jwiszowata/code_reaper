from django.http import HttpResponse
from django.shortcuts import render

from .models import Question, Function
import random
from random import choices

def index(request):
    return render(request, 'code_reaper/index.html')

def task(request, function_id):
    #latest_question_list = Question.objects.order_by('-pub_date')[:5]
    #context = {'latest_question_list': latest_question_list}
    function = Function.objects.get(pk=function_id);
    context = {'function': function, 'next': ((function.id + 1) % 3) + 1}
    return render(request, 'code_reaper/task.html', context)

def game(request):
    random.seed(a=2034)
    context = {
    'size': 20,
    'fields': random.choices(['col1', 'col2', 'col3', 'col4', 'col5', 'col6'], [1,1,1,1,1,1], k=400),
    'colors': ['col1', 'col2', 'col3', 'col4', 'col5', 'col6']
    }
    return render(request, 'code_reaper/game.html', context)

def detail(request, question_id):
    return HttpResponse("You're looking at question %s." % question_id)

def results(request, question_id):
    response = "You're looking at the results of question %s."
    return HttpResponse(response % question_id)

def vote(request, question_id):
    return HttpResponse("You're voting on question %s." % question_id)
