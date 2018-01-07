# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models, migrations


class Migration(migrations.Migration):

    dependencies = [
        ('article', '0001_initial'),
    ]

    operations = [
        migrations.CreateModel(
            name='Comments',
            fields=[
                ('id', models.AutoField(verbose_name='ID', primary_key=True, auto_created=True, serialize=False)),
                ('detail', models.TextField()),
                ('Article', models.ForeignKey(to='article.Article', related_name='article_comment', on_delete=models.PROTECT)),
            ],
        ),
    ]
