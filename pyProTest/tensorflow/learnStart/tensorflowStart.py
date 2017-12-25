# _*_ coding:utf-8 _*_

import tensorflow as tf

# Model parameters， 可以认为是初始值，值的大小关系不大
W = tf.Variable([3], dtype=tf.float32)
b = tf.Variable([-3], dtype=tf.float32)

# Model input and output 就是定义些输入输出
x = tf.placeholder(tf.float32)
liner_model = W * x + b
y = tf.placeholder(tf.float32)

# loss function 损失函数
loss = tf.reduce_sum(tf.square(liner_model - y)) # sum of the square

# optimizer 梯度下降算法，这是个经典算法，可以参照机器学习
optimizer = tf.train.GradientDescentOptimizer(0.01)
train = optimizer.minimize(loss)

# training data 训练数据
x_train = [1,2,3,4]
y_train = [0,-1,-2,-3]

# training loop
init = tf.global_variables_initializer()
sess = tf.Session()
sess.run(init)
for i in range(1000):
    sess.run(train, {x:x_train, y:y_train})

curr_W, curr_b, curr_loss = sess.run([W, b, loss], {x:x_train, y:y_train})
print("W: %s  b: %s   loss: %s" %(curr_W, curr_b, curr_loss))
