from django.db import models
import ast

from django.db import models

class CommaSepField(models.Field):
    "Implements comma-separated storage of lists"

    def __init__(self, separator=",", *args, **kwargs):
        self.separator = separator
        super(CommaSepField, self).__init__(*args, **kwargs)

    def deconstruct(self):
        name, path, args, kwargs = super(CommaSepField, self).deconstruct()
        # Only include kwarg if it's not the default
        if self.separator != ",":
            kwargs['separator'] = self.separator
        return name, path, args, kwargs

class Question(models.Model):
    question_text = models.CharField(max_length=200)
    pub_date = models.DateTimeField('date published')


class Choice(models.Model):
    question = models.ForeignKey(Question, on_delete=models.CASCADE)
    choice_text = models.CharField(max_length=200)
    votes = models.IntegerField(default=0)

class Function(models.Model):
	name = models.CharField(max_length=200, default="Function")
	class_name = models.CharField(max_length=200, default="Class")
	body = models.TextField()
	lines_nr = models.IntegerField(default=0)

	def __str__(self):
		return self.name

class Task(models.Model):
	function = models.ForeignKey(Function, on_delete=models.CASCADE)
	grayed_out_lines = CommaSepField()