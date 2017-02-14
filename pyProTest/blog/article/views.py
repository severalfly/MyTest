from django.http import HttpResponse,Http404,HttpResponseRedirect
from django.shortcuts import render_to_response
from article.models import Article,Comments

# Create your views here

def comment_add(request):
    if request.method == "POST":
        article_id = request.POST.get('article','')

        detail = request.POST.get('detail','')
        # return HttpResponseRedirect('detail',detail)
        if article_id is not '' and detail is not '':
            # pass
            comments = Comments()
            comments.Article = Article(id=article_id)
            comments.detail = detail
            comments.save()
    return HttpResponseRedirect('/show_%s/'%article_id)


def list(request):
    articles = Article.objects.order_by("-id").all()
    return render_to_response('list.html',{'articles':articles})

def add(request):
    if request.method == "POST":
        content = request.POST.get('content',None)
        title = request.POST.get('title',None)
        new = Article(content = content, title = title)
        new.save()
    return render_to_response('add.html',{'method_str':request.method})




def show(request,article_id):
    try:
        article = Article.objects.get(id=article_id)
        comments = Comments.objects.filter(Article=article).order_by("-id").all()
    except Article.DoesNotExist:
        raise Http404("article does not exist!!!")
    return render_to_response('show.html',{'article':article,'comments':comments})

