from django.conf.urls import  url

from . import views

urlpatterns = [
    url(r'^handle$', views.handle, name='handle'),
    url(r'^$', views.index, name='index'),
]
