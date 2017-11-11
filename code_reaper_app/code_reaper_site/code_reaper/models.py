from django.db import models
import ast

from django.db import models

class Function(models.Model):
	name = models.CharField(max_length=200, default="Function")
	class_name = models.CharField(max_length=200, default="Class")
	body = models.TextField()
	lines_nr = models.IntegerField(default=0)


	def __str__(self):
		return self.name

class Task(models.Model):
	function = models.ForeignKey(Function, on_delete=models.CASCADE)
	grayed_out_lines = models.CharField(max_length=200)