# -*- coding: utf-8 -*-
# Generated by Django 1.11.6 on 2017-12-03 14:48
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('code_reaper', '0004_achievement_game_round'),
    ]

    operations = [
        migrations.AlterField(
            model_name='round',
            name='best_result',
            field=models.IntegerField(default=None),
        ),
    ]
