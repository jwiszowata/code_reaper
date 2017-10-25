from django.conf.urls import url

from . import views

urlpatterns = [
	# ex: /code_reaper/
	url(r'^$', views.index, name='index'),
	# ex: /code_reaper/task/1/
    url(r'^task/(?P<function_id>[0-9]+)/$', views.task, name='task'),
    # ex: /polls/5/
    url(r'^(?P<question_id>[0-9]+)/$', views.detail, name='detail'),
    # ex: /polls/5/results/
    url(r'^(?P<question_id>[0-9]+)/results/$', views.results, name='results'),
    # ex: /polls/5/vote/
    url(r'^(?P<question_id>[0-9]+)/vote/$', views.vote, name='vote'),
]