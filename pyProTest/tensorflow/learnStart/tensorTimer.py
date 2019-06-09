# _* coding:utf-8 _*_

'''
a simple timer
'''

import tensorflow as tf 

state = tf.Variable(0, name="counter")

one = tf.constant(1)

new_value = tf.add(state, one)

update = tf.assign(state, new_value)


init_op = tf.initialize_all_variables()

with tf.Session() as sess:
	sess.run(init_op)
	print 'test'
	print sess.run(state)
	print 'done frist'

	for _ in range(3):
		sess.run(update)
		print sess.run(state)