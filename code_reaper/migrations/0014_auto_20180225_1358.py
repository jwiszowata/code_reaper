# -*- coding: utf-8 -*-
# Generated by Django 1.11.6 on 2018-02-25 13:58
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('code_reaper', '0013_auto_20180225_1356'),
    ]

    operations = [
        migrations.AlterField(
            model_name='achievement',
            name='gained_wheat',
            field=models.IntegerField(default=1),
        ),
    ]
