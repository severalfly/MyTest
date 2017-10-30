'''
统计当前目录低下，代码行数
'''
import os
import os.path


def tree(directory):
    # print(os.listdir(directory))
    x,y,z = (0,0,0)
    for filename in os.listdir(directory):
        path = directory +'\\'+ filename
        if os.path.isdir(path):

            print('dir ' + path)
            tree(path)
        elif os.path.isfile(path):
            if not path.endswith('.py') or path.endswith('.java') or path.endswith('.c'):
                continue
            print('file ' + path)
            x1, y1, z1 = lines(path)
            print(x + x1,y + y1,z + z1)
            # return x , y, z
            return x + x1,y + y1,z + z1
        else:
        	print('else ' + path)
        # return res

def lines(filename):
    file = open(filename, mode='r', buffering=-1, encoding='utf-8', errors=None, newline=None, closefd=True)
    inside = False  # 是否在段注释中
    x , y, z =0,0,0 # x 代码；y 注释；z 空行
    for line in file.readlines():
        line = line.strip()
        if not line:
            z +=1
        elif str(line).find('/*') >= 0:
            y += 1
            inside = True
        elif str(line).find('*/') >= 0:
            y +=1
            inside = False
        elif inside:
            y +=1
        elif str(line).find('//') >= 0 or str(line).startswith('#'):
            y += 1
        else:
            x += 1

    return x,y,z



if __name__ == '__main__':
    print(tree('.'))
    # tree(r'D:\\learning\\MyTest\\pyProTest\\showMeTheCode')
    # print(lines('test.java'))
    # print(str('aaaatta').index('tt'))
