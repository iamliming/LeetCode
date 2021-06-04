import numpy as np
import math
import matplotlib.pyplot as plt
import sympy

def sigmoid(x):
    return 1/(1+np.exp(x))
def relu(x):
    return np.where(x < 0,0,x)
def sinx(x):
    return math.sin(x)

x = np.arange(-10, 10, 0.1)
y = sigmoid(x)
y1 = relu(x)
plt.plot(x, y, label="sigmoid")
plt.plot(x, y1, label="relu")
plt.xlabel("x")
plt.ylabel("y")
plt.legend()
plt.show()
# y = []
# for t in x:
#     #y_1 = 1 / (1 + math.exp(-t))
#     y_1 = t**2
#     y_2 = math.e**t
#     y.append(y_1)
#     y.append(y_2)
# plt.plot(x, y, label="sigmoid")
# # plt.xlabel("x")
# # plt.ylabel("y")
# plt.ylim(-100, 100)

# plt.legend()
# plt.show()

# x = np.linspace(0, 2 * np.pi, 100)
# y1, y2 = np.sin(x), np.cos(x)
# x=Symbol("x")
# y3 = diff(1/(1+x**2),x)
# plt.plot(x, y1)
# plt.plot(x, y3)
#
# plt.title('line chart')
# plt.xlabel('x')
# plt.ylabel('y')
#
# plt.show()



#y1 = x^3
