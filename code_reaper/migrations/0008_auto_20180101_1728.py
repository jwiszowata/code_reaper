# -*- coding: utf-8 -*-
# Generated by Django 1.11.6 on 2018-01-01 17:28
from __future__ import unicode_literals

from django.conf import settings
from django.db import migrations, models
import django.db.models.deletion
import django.utils.timezone


class Migration(migrations.Migration):

    dependencies = [
        migrations.swappable_dependency(settings.AUTH_USER_MODEL),
        ('code_reaper', '0007_auto_20171203_1453'),
    ]

    operations = [
        migrations.CreateModel(
            name='Package',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('checking_task', models.IntegerField()),
                ('setting_time', models.DateTimeField(default=django.utils.timezone.now)),
                ('status', models.IntegerField(choices=[(0, 'Pending'), (1, 'Ok'), (2, 'Wrong'), (3, 'Trusted'), (4, 'Not trusted')], default=0)),
            ],
        ),
        migrations.AddField(
            model_name='achievement',
            name='factor',
            field=models.FloatField(default=1.0),
        ),
        migrations.AddField(
            model_name='achievement',
            name='status',
            field=models.IntegerField(choices=[(0, 'Standard'), (1, 'Trusted')], default=0),
        ),
        migrations.AddField(
            model_name='function',
            name='setting_time',
            field=models.DateTimeField(default=django.utils.timezone.now),
        ),
        migrations.AddField(
            model_name='function',
            name='status',
            field=models.IntegerField(choices=[(0, 'Ready'), (1, 'Pending'), (2, 'Finished'), (3, 'Done')], default=0),
        ),
        migrations.AddField(
            model_name='function',
            name='times_done',
            field=models.IntegerField(default=0),
        ),
        migrations.AddField(
            model_name='task',
            name='status',
            field=models.IntegerField(choices=[(0, 'Trusted'), (1, 'Not trusted'), (2, 'Waiting')], default=0),
        ),
        migrations.AddField(
            model_name='package',
            name='task1',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='task1', to='code_reaper.Task'),
        ),
        migrations.AddField(
            model_name='package',
            name='task2',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='task2', to='code_reaper.Task'),
        ),
        migrations.AddField(
            model_name='package',
            name='task3',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='task3', to='code_reaper.Task'),
        ),
        migrations.AddField(
            model_name='package',
            name='user',
            field=models.ForeignKey(default=None, on_delete=django.db.models.deletion.CASCADE, to=settings.AUTH_USER_MODEL),
        ),
        migrations.AddField(
            model_name='achievement',
            name='current_package',
            field=models.ForeignKey(null=True, on_delete=django.db.models.deletion.CASCADE, to='code_reaper.Package'),
        ),
    ]