import re;
import sys;
import cookielib;
import urllib;
import urllib2;
import optparse;
import json;
import httplib2;
 
#reload(sys)
#sys.setdefaultencoding('utf8');
 
def Login():
  
    cj = cookielib.CookieJar();
    opener = urllib2.build_opener(urllib2.HTTPCookieProcessor(cj));
    urllib2.install_opener(opener);

Url = "https://kyfw.12306.cn/otn/passcodeNew/getPassCodeNew?module=login&rand=sjrand";
resp = urllib2.urlopen(Url);

with open("code.png", "wb") as image:
        image.write(resp.read())
         
codeStr = sys.stdin.readline();
codeStr = codeStr[:-1]

ajax_url = "https://kyfw.12306.cn/otn/passcodeNew/checkRandCodeAnsyn";
dc = {
        'randCode'      :  codeStr,
        'rand'      : "sjrand"
    };
request = urllib2.Request(ajax_url, urllib.urlencode(dc))
request.add_header("Content-Type", "application/x-www-form-urlencoded; charset=utf-8")
request.add_header('X-Requested-With','XMLHttpRequest')
request.add_header('User-Agent','Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.154 Safari/537.36')
request.add_header('Referer','https://kyfw.12306.cn/otn/login/init')
request.add_header('Accept','*/*')
request.add_header('Accept-Encoding','gzip, deflate')
 
f = urllib2.urlopen(request) 
print(f.read())

LoginUrl = "https://kyfw.12306.cn/otn/login/loginAysnSuggest";
dc = {
         'randCode'      :  codeStr,
         'userDTO.password'     : "你的密码",
        'loginUserDTO.user_name': "你的账号"
    };