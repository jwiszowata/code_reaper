# -*- coding: utf-8 -*-
# Generated by Django 1.11.6 on 2018-02-25 13:56
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('code_reaper', '0012_function_level'),
    ]

    operations = [
        migrations.AddField(
            model_name='achievement',
            name='gained_wheat',
            field=models.IntegerField(default=0),
        ),
        migrations.AlterField(
            model_name='task',
            name='status',
            field=models.IntegerField(choices=[(0, 'Trusted'), (1, 'Not trusted'), (2, 'Waiting'), (3, 'Best')], default=0),
        ),
    ]