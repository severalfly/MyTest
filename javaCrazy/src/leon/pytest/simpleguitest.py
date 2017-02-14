#_*_utf-8_*_

import simpleguitk as simplegui
'''
message = "Welcome"

def click():
	global message
	message = "Good job!"


def draw(canvas):
	canvas.draw_text(message, (50,112), 36, "Red")


frame = simplegui.create_frame("Home", 300, 200)
frame.add_button("Click me", click)
frame.set_draw_handler(draw)

frame.start()
'''

'''
counter = 0

def increment():
	global counter
	counter = counter +1


def tick():
	increment()
	print(counter)

def buttonPress():
	global counter
	counter = 0


frame = simplegui.create_frame("SimpleGUI", 100, 100)

timer = simplegui.create_timer(1000, tick)
frame.add_button("Click me", buttonPress)

timer.start()
frame.start()
'''

store = 0
operand = 0

def output():
	print("Store = ", store)
	print("Operand = ", operand)
	print()

def swap():
	global store,operand
	store,operand = operand,store
	output()

def add():
	global store, operand
	store = store + operand
	output()

def minus():
	global store, operand
	store = store - operand
	output()

def multi():
	global store, operand
	store = store * operand
	output()

def div():
	global store, operand
	store = store / operand
	output()


def enter(inp):
	global operand
	operand = float(inp)
	output()



frame = simplegui.create_frame("Calcute", 300, 200)

frame.add_button("print", output)
frame.add_button("Swap", swap)
frame.add_button("add", add)
frame.add_button("minus", minus)
frame.add_button("multi", multi)
frame.add_button("div", div)
frame.add_input("Enter operand", enter, 100)

frame.start()

