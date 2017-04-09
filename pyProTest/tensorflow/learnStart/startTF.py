# _*_ coding:utf-8 _*_

import tensorflow as tf

matrix1 = tf.constant([[3., 3.]])

matrix2 = tf.constant([[2., 2.]])

product = tf.matmul(matrix1, matrix2)



# start a session
sess = tf.session()

res = sess.run(product)

print res
