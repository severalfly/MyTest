# _*_coding:utf-8_*_
import tensorflow as tf
# numpy is often used to load, manipulate and preprocess data
import numpy as np

'''
自定义模型函数，用于比较复杂的方法
'''
def model_fn(features, labels, mode):
    W = tf.get_variable("W", [1], dtype=tf.float64)
    b = tf.get_variable("b", [1], dtype=tf.float64)
    y = W * features['x'] + b

    loss = tf.reduce_sum(tf.square(y - labels))

    global_step = tf.train.get_global_step()
    optimizer = tf.train.GradientDescentOptimizer(0.01)
    train = tf.group(optimizer.minimize(loss), tf.assign_add(global_step, 1))

    return tf.estimator.EstimatorSpec(mode = mode, predictions = y, loss = loss, train_op = train)

# declare list of features. we only have one numeric feature. there are many
# other types of columns that are more complicated and useful

# feature_column = [tf.feature_column.numeric_column("x", shape=[1])]


# An estimator is the fromt end to invoke training (fitting) and evaluation
# (inference). There are many predefined types like linear regression,
# linear classification, and many neural network classifiers an regressors
# The following code provides an estimator that does linear regression
# estimator = tf.estimator.LinearRegressor(feature_columns=feature_column)

estimator = tf.estimator.Estimator(model_fn=model_fn)

# TensorFlow provides many helper methods to read and set up data sets
# Here we use two data sets: one for training and one for evaluation
# We have to tell the function how many batches
# of data( num_epochs) we want and how big each batch should be
x_train = np.array([1., 2., 3., 4.])
y_train = np.array([0., -1., -2., -3.])
x_eval = np.array([2., 5., 8, 1])
y_eval = np.array([-1.01, -4.1, -7, 0])

input_fn = tf.estimator.inputs.numpy_input_fn(
    {"x": x_train}, y_train, batch_size=4, num_epochs=None, shuffle=True)
train_input_fn = tf.estimator.inputs.numpy_input_fn(
    {"x": x_train}, y_train, batch_size=4, num_epochs=1000, shuffle=False)
eval_input_fn = tf.estimator.inputs.numpy_input_fn(
    {"x": x_eval}, y_eval, batch_size=4, num_epochs=1000, shuffle=False)


#  We can invoke 1000 training steps by invoking the method and passing the
# training data set
estimator.train(input_fn=input_fn, steps=1000)

# Here we evaluate how well our model did
train_metrics = estimator.evaluate(input_fn=train_input_fn)
eval_metrics = estimator.evaluate(input_fn=eval_input_fn)
print("train metrics: %r" % train_metrics)
print("eval metrics: %r" % eval_metrics)
