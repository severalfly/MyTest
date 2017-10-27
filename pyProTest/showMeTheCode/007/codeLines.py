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
            # lines(path)
        else:
        	print('else ' + path)

def lines(filename):
    file = open(filename, mode='r', buffering=-1, encoding='utf-8', errors=None, newline=None, closefd=True)
    inside = False  # 是否在段注释中
    x , y, z =0,0,0 # x 代码；y 注释；z 空行
    for line in file.readlines():
        # print(type(line))
        line = line.strip()
        if not line:
            z +=1
        elif str(line).find('/*') > -1:
            y += 1
            inside = True
        elif str(line).find('*/') > -1:
            y +=1
            inside = False
        elif inside:
            y +=1
        elif str(line).find('//') > -1:
            y += 1
        else:
            x += 1

    return (x,y,z)



if __name__ == '__main__':
	# tree('.')
    # tree(r'D:\\leontest\\MyTest\\pyProTest\\pythonBase')
    print(lines('D:\\leontest\\MyTest\\pyProTest\\showMeTheCode\\007\\test.java'))
    # print(str('aaaatta').index('tt'))
