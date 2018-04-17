from django.conf.urls import url, include
# from django.contrib.auth.views import login
from django.contrib.auth import views as auth_views

from . import views

# LOGIN_URL = 'login'
# LOGOUT_URL = 'logout'
# LOGIN_REDIRECT_URL = 'home'

urlpatterns = [
	# ex: /code_reaper/
	url(r'^$', views.index, name='index'),
	# ex: /code_reaper/task/1/
    url(r'^task/$', views.task, name='task'),
    url(r'^task/gray_out/(?P<function_id>[0-9]+)$', views.gray_out, name='gray_out'),
    url(r'^games/$', views.games, name='games'),
    url(r'^game/$', views.game, name='game'),
    url(r'^game/move/$', views.make_move, name='make_move'),
    url(r'^user/$', views.user, name='user'),
    url(r'^sign/$', views.sign, name='sign'),
    url(r'^signup/$', views.signup_view, name='signup'),
    #url(r'^login/$', login, name='login'),
    #url(r'^logout/$', views.logout_view, name='logout'),
    url(r'^ranking/$', views.ranking, name='ranking'),
    url(r'^summarize/$', views.summarize_day, name='summarize_day'),
    url(r'^login/$', views.login_view, name='login'),
    url(r'^logout/$', views.logout_view, name='logout'),
    url(r'^oauth/', include('social_django.urls', namespace='social')),  # <--
    url(r'^about/$', views.about, name='about'),
]
