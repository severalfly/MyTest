#_*_coding:utf-8_*_

import simpleguitk as simplegui
import random


inNum = 0
cnt = 0

def outputRange():
	global inNum,cnt
	print('New game, Range is 0 to ', inNum)
	print('Number of remaining guesses is: ', cnt)



def range100():
	global inNum,cnt
	inNum = random.randint(0,100)
	cnt = 7
	outputRange()


def range1000():
	global inNum,cnt
	inNum = random.randint(0,1000)
	cnt = 10
	outputRange()

def enter(inp):
	global inNum, cnt
	c = int(inp)
	print('Enter Number is: %i'%c)
	cnt = cnt -1
	print('Number of remaining guesses is: %i'%cnt)
	if c > inNum:
		print("Higher")
	elif c < inNum:
		print('Lower')
	else:
		print("great, the number is: %i"%inNum)
	




frame = simplegui.create_frame("Guess the num", 300,300)
frame.add_button("Range in [0,100]", range100)
frame.add_button("Range in [0,1000]", range1000)
frame.add_input("Enter a guess", enter, 100)
if __name__ == '__main__':
	range100()
	frame.start()