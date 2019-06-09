#_*_coding:utf-8_*_

import simpleguitk as simplegui
import random

message = "I love Python"
position = [100,100]
width = 500
highest = 500

# define draw handler
def draw(canvas):
	canvas.draw_text(message,(position[0],position[1]), 23, "Red")

# define enter handler
def enter(inp):
	global message
	message = inp

# define timer handler
def tick():
	global position
	x = random.randint(0,width)
	y = random.randint(0,highest)
	position[0] = x
	position[1] = y



# create frame
frame = simplegui.create_frame("Test",width,highest)
timer = simplegui.create_timer(1000, tick)

# register draw handler
frame.set_draw_handler(draw)
frame.add_input("Enter Message",enter, 100)


# start frame
timer.start()
frame.start()

