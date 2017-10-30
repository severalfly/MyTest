from django.shortcuts import render
from django.http import HttpResponse
from django.http import HttpRequest
import hashlib

# Create your views here.
def index(request):
    print(request.POST.getlist('aa') )
    print('aaaaaaaaaaaaaaaaaa')
    return HttpResponse('hello, world, this is wechat index')

def handle(request):
    # print(request.GET.get('page'))
    signature = request.GET.get('signature')
    timestamp =  request.GET.get('timestamp')
    nonce =  request.GET.get('nonce')
    echostr =  request.GET.get('echostr')
    token = 'leon'
    list = [token, timestamp, nonce]
    list.sort()
    sha1 = hashlib.sha1()
    map(sha1.update, list)
    hashcode = sha1.hexdigext()
    print('handle/GET func: hashcode, signature: ', hashcode, signature )
    if hashcode == signature:
        return echostr
    else:
        return ""
    # return HttpResponse('hello, world, this is wechat handle ' + page)
