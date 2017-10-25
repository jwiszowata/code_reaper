from django.contrib import admin

# Register your models here.

from .models import Function, Task

admin.site.register(Function)
admin.site.register(Task)