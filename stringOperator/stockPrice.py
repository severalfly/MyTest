# _*_coding:utf-8_*_

import urllib.request as req
import re
import time
stockNo = input("请输入股票号码: ")
refreshTime = input("请输入刷新时间: ")
if len(refreshTime)==0:
    refreshTime = 10
else:
    refreshTime = int(refreshTime)
url = 'http://www.baidu.com/baidu?wd='+stockNo + '&tn=monline_4_dg'
regRealTime = 'op-stockdynamic-moretab-cur-num c-gap-right-small">(.*?)</span><i '
regYesterday = '昨收</span><span class="op-stockdynamic-moretab-info-value">(.*?)</span></li>'


html = req.urlopen(url)
content = html.read().decode('utf-8')
list1 = re.findall(regYesterday, content)

while True:
    
    print(time.ctime())
    print('实时：'+re.findall(regRealTime, content)[0]+'元')
    print('昨收：' +re.findall(regYesterday, content)[0]+ '元')
    print()
    time.sleep(refreshTime)

