# -*- coding: utf-8 -*-
# Generated by Django 1.11.6 on 2017-11-25 19:51
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('code_reaper', '0002_task_user'),
    ]

    operations = [
        migrations.AddField(
            model_name='task',
            name='time',
            field=models.IntegerField(default=0),
        ),
    ]
