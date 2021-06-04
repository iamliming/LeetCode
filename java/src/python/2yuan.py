import matplotlib.pyplot as plt
import numpy as np
import math
#构造等高线函数
def f(x,y):
    return x**2+y**2-4
# def g(x,y):
    # return x**3+y**3-4
    # math.sin(math.pi*x)/(x**2 - 1)
    # return math.sin(x) -x*y
#定义点的数量
n=5000

#作点
x=np.linspace(-20,20,500)
y=np.linspace(-20,20,500)
z=np.linspace(-20,20,500)

#构造网格
X,Y=np.meshgrid(x,y)
plt.figure(figsize=(10,10))
#绘制图像
# plt.contour(X,Y,f(X,Y),0)
print(math.sin(-20))
plt.contour(X,Y,f(X,Y),0)
#作其他图像
# plt.plot(x,y)
plt.show()