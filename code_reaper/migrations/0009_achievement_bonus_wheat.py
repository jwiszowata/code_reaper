# -*- coding: utf-8 -*-
# Generated by Django 1.11.6 on 2018-01-01 21:04
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('code_reaper', '0008_auto_20180101_1728'),
    ]

    operations = [
        migrations.AddField(
            model_name='achievement',
            name='bonus_wheat',
            field=models.IntegerField(default=0),
        ),
    ]
