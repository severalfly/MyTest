from django.db import models

# Create your models here.

class Article(models.Model):
	title = models.CharField(max_length=30)
	content = models.TextField()

class Comments(models.Model):
	Article = models.ForeignKey(Article, related_name='article_comment', on_delete=models.PROTECT)
	detail = models.TextField()

# from django.db import models


class Question(models.Model):
    question_text = models.CharField(max_length=200)
    pub_date = models.DateTimeField('date published')


class Choice(models.Model):
    question = models.ForeignKey(Question, on_delete=models.CASCADE)
    choice_text = models.CharField(max_length=200)
    votes = models.IntegerField(default=0)
