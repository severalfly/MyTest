# _*_coding:utf-8_*_

'''
里面的内容为以下内容，当用户输入敏感词语时，则打印出 Freedom
'''
import re
l = {}
for line in open('filtered_words.txt', encoding='utf-8').readlines():
    l[str(line).replace('\n','')] = 1

while True:
    word = input('please input word: ')
    if not word:
        break;
    if l.get(word):
        print('Freedom')
    else:
        print('Human Rights')
# print(l)

while True:
    word = input('Please input aganin: ')
    # word = word.strip()
    if not word:
        break
    else:
        for key in l.keys():
            word = re.sub(key, '*'*len(key), word)
        print(word)
