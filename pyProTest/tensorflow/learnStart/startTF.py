# _*_ coding:utf-8 _*_

import tensorflow as tf

matrix1 = tf.constant([[3., 3.]])

matrix2 = tf.constant([[2.], [2.]])

product = tf.matmul(matrix1, matrix2)


'''
# start a session
sess = tf.Session()
# ->  [[ 12.]]

res = sess.run(product)

print 'result is: ' 
print res
'''

with tf.Session() as sess:
  result = sess.run(product)
  print result