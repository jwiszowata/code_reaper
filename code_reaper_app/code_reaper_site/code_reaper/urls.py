from django.conf.urls import url

from . import views

urlpatterns = [
	# ex: /code_reaper/
	url(r'^$', views.index, name='index'),
	# ex: /code_reaper/task/1/
    url(r'^task/(?P<function_length>[0-9]+)/$', views.task, name='task'),
    url(r'^(?P<function_id>[0-9]+)/gray_out/$', views.gray_out, name='gray_out'),
    url(r'^game/$', views.game, name='game'),
    url(r'^game/move/$', views.make_move, name='make_move'),
    # ex: /polls/5/
    #url(r'^(?P<question_id>[0-9]+)/$', views.detail, name='detail'),
    # ex: /polls/5/results/
    #url(r'^(?P<question_id>[0-9]+)/results/$', views.results, name='results'),
    # ex: /polls/5/vote/
    #url(r'^(?P<question_id>[0-9]+)/vote/$', views.vote, name='vote'),
]