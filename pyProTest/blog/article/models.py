from django.db import models

# Create your models here.

class Article(models.Model):
	title = models.CharField(max_length=30)
	content = models.TextField()

class Comments(models.Model):
	Article = models.ForeignKey(Article, related_name='article_comment')
	detail = models.TextField()