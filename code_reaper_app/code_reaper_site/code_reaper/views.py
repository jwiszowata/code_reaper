from django.http import HttpResponse
from django.shortcuts import render

#from .models import Question, Function
import random
import numpy as np
import queue
import json

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
    size = 20;
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

def make_move(request):
    if request.method == 'GET':
        request.session["steps"] = request.session["steps"] + 1
        color = int(request.GET.get("color"))
        if color in request.session['colors']:
            fields = updateBoard(request.session['fields'], request.session['size'], color)
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
        print("sprawdzamy", fRow, fCol)
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
                    print(r, c)
        wypisz(vis, 5)
    return board.reshape((1, size * size)).tolist()[0]


def wypisz(t, s):
    for i in range(s):
        res = ""
        for j in range(s):
            res = res + "%r " % (t[i,j])
        print(res)

# def detail(request, question_id):
#     return HttpResponse("You're looking at question %s." % question_id)

# def results(request, question_id):
#     response = "You're looking at the results of question %s."
#     return HttpResponse(response % question_id)

# #def vote(request, question_id):
#     return HttpResponse("You're voting on question %s." % question_id)
