from django.contrib import admin

# Register your models here.

from .models import Function, Task, Game, Round, Achievement

admin.site.register(Function)
admin.site.register(Task)
admin.site.register(Game)
admin.site.register(Round)
admin.site.register(Achievement)