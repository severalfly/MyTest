#_*_coding:utf-8_*_


import simpleguitk as simplegui

minute = 0
second = 0
dsecond = 0

isRun = False

cntWin = 0
cntTry = 0


# 定时器动作
def tick():
	global minute,second,dsecond
	if not isRun:
		return
	dsecond = dsecond +1
	if dsecond>= 10:
		second = second +1
		dsecond = 0

	if second >= 60:
		minute = minute +1
		second = 0


def start():
	global isRun
	isRun = True

def stop():
	global isRun,cntTry,cntWin,second, dsecond
	if isRun:
		cntTry = cntTry +1
		if second % 5 is 0 and dsecond is 0:
			cntWin = cntWin +1
	isRun = False

def reset():
	global minute,second,dsecond,isRun,cntWin,cntTry
	isRun = False
	minute = 0
	second = 0
	dsecond = 0
	cntTry = 0
	cntWin = 0


def keyDown():
	# print(KEY_MAP[0])
	stop()


# 将时间画去画布上
def draw(canvas):
	global minute,second,dsecond,cntWin,cntTry
	msg = str(minute) + ":" + str(second) + "." + str(dsecond)
	canvas.draw_text(msg, (100,100),50,"Red")
	canvas.draw_text(str(cntWin) + "/" + str(cntTry), (400,30), 30, "Blue")

frame = simplegui.create_frame("StopWatch",500,500)
timer = simplegui.create_timer(100,tick)

frame.set_draw_handler(draw)
frame.add_button("start",start)
frame.add_button("stop",stop)
frame.add_button("reset",reset)

frame.set_keydown_handler(keyDown)




timer.start()
frame.start()