from django.db import models
import ast
from django.contrib.auth.models import User
import math
from django.utils.timezone import now

class Function(models.Model):
	READY = 0
	PENDING = 1
	FINISHED = 2
	DONE = 3
	FUNCTION_STATUS_CHOICES = (
		(READY, 'Ready'),# można brać
	    (PENDING, 'Pending'),# oczekuje na podliczenie pakietu
	    (FINISHED, 'Finished'),# ma 3 zaufane rozwiązania
	    (DONE, 'Done'),# zostaly za nią przyznane nocne punkty
	)
	name = models.CharField(max_length=200, default="Function")
	project = models.CharField(max_length=200, default="Project")
	class_name = models.CharField(max_length=200, default="Class")
	body = models.TextField()
	lines_nr = models.IntegerField(default=0)
	signs_nr = models.IntegerField(default=0)
	difficulty = models.IntegerField(default=0)
	level = models.IntegerField(default=0)
	times_done = models.IntegerField(default=0)
	status = models.IntegerField(default=0, choices=FUNCTION_STATUS_CHOICES)
	setting_time = models.DateTimeField(default=now)

	def __str__(self):
		return str(self.pk)

class Task(models.Model):
	TRUSTED = 0
	NOT_TRUSTED = 1
	WAITING = 2
	BEST = 3

	TASK_STATUS_CHOICES = (
		(TRUSTED, 'Trusted'),
		(NOT_TRUSTED, 'Not trusted'),
		(WAITING, 'Waiting'),
		(BEST, 'Best'),
	)
	function = models.ForeignKey(Function, on_delete=models.CASCADE)
	user = models.ForeignKey(User, default=None)
	time = models.IntegerField(default=0)
	grayed_out_lines = models.CharField(max_length=200)
	status = models.IntegerField(default=0, choices=TASK_STATUS_CHOICES)

	def __str__(self):
		return str(self.user.username) + " " + str(self.function)

class Package(models.Model):
	PENDING = 0
	#OK = 1
	#WRONG = 2
	TRUSTED = 3
	NOT_TRUSTED = 4

	PACKAGE_STATUS_CHOICES = (
		(PENDING, 'Pending'),
		#(OK, 'Ok'), gdybym zliczała po 9
		#(WRONG, 'Wrong'), gdybym zliczała po 9
		(TRUSTED, 'Trusted'),
		(NOT_TRUSTED, 'Not trusted'),
	)
	user = models.ForeignKey(User, default=None)
	function1 = models.ForeignKey(Function, related_name='function1', default=None)
	function2 = models.ForeignKey(Function, related_name='function2', default=None)
	function3 = models.ForeignKey(Function, related_name='function3', default=None)
	task1 = models.ForeignKey(Task, related_name='task1', default=None, null=True)
	task2 = models.ForeignKey(Task, related_name='task2', default=None, null=True)
	task3 = models.ForeignKey(Task, related_name='task3', default=None, null=True)
	checking_function = models.IntegerField(default=0)
	setting_time = models.DateTimeField(default=now)
	status = models.IntegerField(default=0, choices=PACKAGE_STATUS_CHOICES)

	def __str__(self):
		return str(self.user.username)

class Game(models.Model):
	number = models.IntegerField()
	seed = models.IntegerField(default=2345)

	def __str__(self):
		return str(self.number) + " " + str(self.seed)

class Round(models.Model):
	game = models.ForeignKey(Game, on_delete=models.CASCADE)
	user = models.ForeignKey(User)
	best_result = models.IntegerField(null=True)
	times = models.IntegerField()

	def __str__(self):
		return str(self.user.pk) + " " + str(self.best_result) + " " + str(self.game)

class Achievement(models.Model):
	STANDARD = 0
	TRUSTED = 1

	PLAYER_STATUS_CHOICES = (
		(STANDARD, 'Standard'),
		(TRUSTED, 'Trusted')
	)
	user = models.ForeignKey(User)
	points = models.IntegerField(default=0)
	level = models.IntegerField(default=1)
	wheat = models.IntegerField(default=1)
	factor = models.FloatField(default=1.0)
	status = models.IntegerField(default=0, choices=PLAYER_STATUS_CHOICES)
	current_package = models.ForeignKey(Package, null=True)
	bonus_wheat = models.IntegerField(default=0)
	gained_wheat = models.IntegerField(default=1)
