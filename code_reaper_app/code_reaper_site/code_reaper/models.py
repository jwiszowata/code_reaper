from django.db import models
import ast
from django.contrib.auth.models import User

class Function(models.Model):
	name = models.CharField(max_length=200, default="Function")
	project = models.CharField(max_length=200, default="Project")
	class_name = models.CharField(max_length=200, default="Class")
	body = models.TextField()
	lines_nr = models.IntegerField(default=0)
	signs_nr = models.IntegerField(default=0)
	difficulty = models.IntegerField(default=0)

	def __str__(self):
		return self.name + " from " + self.class_name

class Task(models.Model):
	function = models.ForeignKey(Function, on_delete=models.CASCADE)
	user = models.ForeignKey(User, default=None)
	time = models.IntegerField(default=0)
	grayed_out_lines = models.CharField(max_length=200)

