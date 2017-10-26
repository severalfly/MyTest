'''
统计当前目录低下，代码行数
'''
import os
import os.path


def tree(directory):
    # print(os.listdir(directory))
    for filename in os.listdir(directory):
        path = directory +'\\'+ filename
        if os.path.isdir(path):

            print('dir ' + path)
            tree(path)
        elif os.path.isfile(path):
            print('file ' + path)
        else:
        	print('else ' + path)

if __name__ == '__main__':
	# tree('.')
    tree(r'D:\\leontest')
