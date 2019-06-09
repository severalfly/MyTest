#_*_coding:utf-8_*_

import urllib
from BeautifulSoup import *

url = input('Enter - ')
html = urllib.request.urlopen(url).read()
soup = BeautifulSoup(html)

tags = soup('a')

for tag in tags:
	print(tag.get('href',None))