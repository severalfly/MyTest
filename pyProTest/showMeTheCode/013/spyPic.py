# _*_coding:utf-8_*_

import urllib.request as req
import re

url = 'http://tieba.baidu.com/p/2166231880'
# url = 'http://tieba.baidu.com/p/5311516307'
conn = req.urlopen(url)
html = conn.readlines()
s = ''
urls = []
for line in html:
    r = re.findall(r'src=\"(http://imgsrc.+?\.jpg)\"',str(line))
    if r:
        for a in r:
            urls.append(a)
            
    #s = s  + str(line)

# 已经把链接搞出来了，下面把图片下载下来

for url in urls:
    req.urlretrieve(url, 'image\\' + url[-24:-4] + '.jpg')

