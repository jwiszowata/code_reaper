import random
import numpy as np
import queue
from django.test import TestCase
from django.test import Client

from .models import Game, Function
import code_reaper.views as v

from django.contrib.auth.models import User
from django.core.urlresolvers import reverse
from django.test.client import Client
import unittest
import json

class TestGameModel(TestCase):

	def setUp(self):
		self.seeds = random.choices(range(1287, 9853), k=10)
		self.game = Game(seed=1000, number=100)
		self.size = 15
		self.colors = [1, 2, 3, 4, 5, 6]

	def test_str(self):
		assert self.game.__str__() == "100 1000"

# nie działa dla seed = 3716, seed = 9810, seed = 1527
	def test_basic_getActiveQueue(self):
		for seed in self.seeds:
			fields = v.generateBoardFields(self.size, self.colors, seed)
			updatedFields = v.updateBoardFields(fields, self.size, fields[0]['color'])
			board = np.asarray(fields).reshape((self.size, self.size))
			q = v.getActiveQueue(board, self.size)
			if board[0, 0]["color"] != board[0, 1]["color"]:
				if board[0, 0]["color"] != board[1, 0]["color"]: 
					assert q.qsize() == 1, "q.qsize = %r, seed = %r" % (q.qsize(), seed) # 1.
				else:
					assert q.qsize() >= 2, "q.qsize = %r, seed = %r" % (q.qsize(), seed) # 2.
			else:
				if board[0, 0]["color"] != board[1, 0]["color"]:
					assert q.qsize() >= 2, "q.qsize = %r, seed = %r" % (q.qsize(), seed) # 3.
				else:
					assert q.qsize() >= 3, "q.qsize = %r, seed = %r" % (q.qsize(), seed) # 4.
			# 1. x o # 2. x o # 3. x x # 4. x x
			#	 o   #	  x   #	   o   #	x

	#def tearDown(self):
		#print("<(\")")
		#self.game.disappear()
	# def test_makeMove(self):
	# 	c = Client()
	# 	response = c.post('/code_reaper/login/', {'username': 'admin', 'password': 'owieczka1'})
	# 	assert response.status_code == 200, "request status = %r" % response
	# 	game_response = c.post('/code_reaper/game/', {'nr': 1})
	# 	assert game_response.status_code == 200, "request status = %r" % game_response
	# 	move_response = c.get('/code_reaper/make_move/', {'color': 2})
	# 	assert move_response.status_code == 200, "request status = %r" % move_response

class LoginTestCase(TestCase):
	def setUp(self):
		self.client = Client()
		self.user = User.objects.create_user('john', 'lennon@thebeatles.com', 'johnpassword')
		self.games_nr = 16
		for i in range(1, self.games_nr + 1):
			self.game = Game(number=i, seed=1232)
			self.game.save()
		self.colors = [1, 2, 3, 4, 5, 6]
		self.client.login(username='john', password='johnpassword')
		response = self.client.get(reverse('login'))
		self.assertEqual(response.status_code, 200)

	def test_basic_makeMove(self):
		game_response = self.client.post('/code_reaper/game/', {'nr': 1})
		assert game_response.status_code == 200, "request status = %r" % game_response
		game_fields = game_response.context["fields"]
		first_color = game_fields[0]["color"]
		move_response = self.client.get('/code_reaper/game/move/', {'color': first_color})
		assert move_response.status_code == 200, "request status = %r" % move_response
		#print(str(move_response.content, encoding='utf8'))
		content = json.loads(str(move_response.content, encoding='utf8'))
		move_fields = content["fields"]
		for color in self.colors:
			g = self.countColor(game_fields, color)
			m = self.countColor(move_fields, color)
			assert g == m, "Firstly game had %r fields of color %r, then after move it has %r fields" % (g, color, m)

	def countColor(self, fields, color):
		res = 0
		for field in fields:
			if field["color"] == color:
				res += 1
		return res

	def test_makeMove(self):
		game_response = self.client.post('/code_reaper/game/', {'nr': 1})
		assert game_response.status_code == 200, "request status = %r" % game_response
		game_fields = game_response.context["fields"]
		first_color = game_fields[0]["color"]

		checked_color = random.choices(self.colors, k=1)
		if first_color == checked_color:
			checked_color += 1

		g = self.countColor(game_fields, checked_color)
		for i in range(1,10):
			for color in self.colors:
				if color != checked_color:
					move_response = self.client.get('/code_reaper/game/move/', {'color': color})
					assert move_response.status_code == 200, "request status = %r" % move_response
					content = json.loads(str(move_response.content, encoding='utf8'))
					move_fields = content["fields"]
					m = self.countColor(move_fields, checked_color)
					assert g == m, "Game had %r fields of color %r, then after choose color %r it has %r fields of color %r" % (g, checked_color, color, m, checked_color)

	def test_basic_games(self):
		games_response = self.client.get('/code_reaper/games/')
		assert games_response.status_code == 200, "request status = %r" % games_response
		games = games_response.context["games"]
		wheat = games_response.context["wheat"]
		self.assertEqual(wheat, 1, "User should starst with 1 wheat not %r" % wheat)
		self.assertEqual(len(games), self.games_nr, 
			"View should return %r games, it returned %r" % (self.games_nr, len(games)))
		i = 1
		for game in games:
			self.assertEqual(game["nr"], i, "%rth game have number %r" % (i, game["nr"]))
			self.assertEqual(len(game["cost"]), 1, "%rth game have cost %r instead of 1" % (i, len(game["cost"])))
			i += 1

	def game_view(self, number):
		game_response = self.client.post('/code_reaper/game/', {'nr': number})
		self.assertEqual(game_response.status_code, 200, "request status = %r" % game_response)
		return game_response

	def games_view(self):
		games_response = self.client.get('/code_reaper/games/')
		self.assertEqual(games_response.status_code, 200, "request status = %r" % games_response)
		return games_response.context

	def ranking_view(self):
		ranking_response = self.client.get('/code_reaper/ranking/')
		self.assertEqual(ranking_response.status_code, 200, "request status = %r" % ranking_response)
		return ranking_response.context

	def task_view(self, status):
		task_response = self.client.get('/code_reaper/task/')
		self.assertEqual(task_response.status_code, status, "request status = %r" % task_response)
		return task_response.context

	def gray_out_view(self, f_id):
		#print(str(f_id), " ", self.function.pk)
		gray_out_response = self.client.post(reverse('gray_out', args=[1]), 
			{'time': 10, 'line1': 1, 'line2': 1})
		self.assertEqual(gray_out_response.status_code, 200, "request status = %r" % gray_out_response)
		return json.loads(str(gray_out_response.content, encoding='utf8'))

	def test_games_wheatUsage(self):
		self.game_view(1)
		games_context = self.games_view()
		wheat = games_context["wheat"]
		self.assertEqual(wheat, 0, "User after one game should have 0 wheat not %r" % wheat)

	def test_basic_ranking(self):
		ranking_context = self.ranking_view()
		coders = ranking_context["code_ranking"]
		self.assertEqual(coders, [], "No task was done so ranking should be empty not equal to %r" % coders)
		games = ranking_context["games_ranking"]
		i = 1
		for game in games:
			self.assertEqual(game["users"], [], 
				"No game was played so ranking should be empty not equal to %r for game %r" % (i, game))
			i += 1

	def test_basic_task(self):
		diff = 20
		self.function = Function(name="f1", project="f", class_name="f", body="a\nb\nc\nd", lines_nr=4, 
			signs_nr=4, level=1, difficulty=diff, times_done=0, status=Function.READY)
		self.function.save()
		self.function = Function(name="f2", project="f", class_name="f", body="a\nb\nc\nd", lines_nr=4, 
			signs_nr=4, level=1, difficulty=diff, times_done=0, status=Function.READY)
		self.function.save()
		self.function = Function(name="f3", project="f", class_name="f", body="a\nb\nc\nd", lines_nr=4, 
			signs_nr=4, level=1, difficulty=diff, times_done=0, status=Function.READY)
		self.function.save()
		task_context = self.task_view(200)

	def test_task_grayOut(self):
		diff = 20
		self.function = Function(name="f", project="f", class_name="f", body="a\nb\nc\nd", lines_nr=4, 
			signs_nr=4, level=1, difficulty=diff, times_done=0, status=Function.READY)
		self.function.save()
		task_context = self.task_view(200)
		self.assertEqual(self.function.pk, task_context["function"].pk, 
			"Id %r is not equal to %r" % (task_context["function"].pk, self.function.pk))
		gray_out_content = self.gray_out_view(self.function.pk)
		self.assertEqual(gray_out_content["got_points"], diff, 
			"Got points(%r) are not equal to difficulty(%r)" % (gray_out_content["got_points"], diff))


# 'got_points': function.difficulty,
#                 'all_points': points,
#                 'got_level': got_level,
#                 'level': level,
#                 'wheat': got_wheat,
#                 'to_next_level': points_max(level) - points }),
		#f_id = task_context["function"]
	# def tearDown(self):
	# 	self.user.delete()
	# 	self.game.delete()

