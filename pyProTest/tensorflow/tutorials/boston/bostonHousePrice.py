# _*_coding:utf-8_*_

import tensorflow as tf
import pandas as pd
import itertools
tf.logging.set_verbosity(tf.logging.INFO)

# 
COLUMNS = ["crim", "zn", "indus", "nox", "rm", "age",
           "dis", "tax", "ptratio", "medv"]
FEATURES = ["crim", "zn", "indus", "nox", "rm",
            "age", "dis", "tax", "ptratio"]
LABEL = "medv"

# import data
training_set = pd.read_csv("boston_train.csv", skipinitialspace=True,
                           skiprows=1, names=COLUMNS)
test_set = pd.read_csv("boston_test.csv", skipinitialspace=True,
                       skiprows=1, names=COLUMNS)
prediction_set = pd.read_csv("boston_predict.csv", skipinitialspace=True,
                             skiprows=1, names=COLUMNS)


feature_cols = [tf.feature_column.numeric_column(k) for k in FEATURES]

# dnn to train
regressor = tf.estimator.DNNRegressor(feature_columns=feature_cols,
                                      hidden_units=[10, 10],
                                      model_dir="/tmp/boston_model")

# the core function
def get_input_fn(data_set, num_epochs=None, shuffle=True):
    return tf.estimator.inputs.pandas_input_fn(
        x=pd.DataFrame({k: data_set[k].values for k in FEATURES}),
        y=pd.Series(data_set[LABEL].values),
        num_epochs=num_epochs,
        shuffle=shuffle)

# start to train
regressor.train(input_fn=get_input_fn(training_set), steps=5000)


# evalute the model
ev = regressor.evaluate(
    input_fn=get_input_fn(test_set, num_epochs=1, shuffle=False)
)

# result
loss_score = ev['loss']
print('Loss: {0:f}'.format(loss_score))

# have a try
y = regressor.predict(
    input_fn=get_input_fn(prediction_set, num_epochs=1, shuffle=False))
predictions = list(p["predictions"] for p in itertools.islice(y, 6))
print("Predictions: {}".format(predictions))
