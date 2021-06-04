
from mpl_toolkits.mplot3d import Axes3D
import numpy as np
from matplotlib import pyplot as plt

fig = plt.figure()
ax = Axes3D(fig)
x=np.arange(-2*np.pi,2*np.pi,0.1)
y=np.arange(-2*np.pi,2*np.pi,0.1)
X, Y = np.meshgrid(x, y)#网格的创建，这个是关键
Z=np.sin(X)*np.cos(Y)
# Z=X**2+Y**2
Z=X**2*Y+np.cos(Y)
# Z1=0.5*(Z)
plt.xlabel('x')
plt.ylabel('y')
ax.plot_surface(X, Y, Z, rstride=1, cstride=1, cmap='rainbow')
# ax.plot_surface(X, Y, Z1, rstride=1, cstride=1, cmap='rainbow')
# 在XY 平面添加n等高线， contourf 是轮廓的意思，contour 也是绘制等高线， 不同的是contourf会对区间进行填充
# ax.contourf(X,Y,Z, zdir="z", offset=-2, cmap=plt.get_cmap("rainbow"))
plt.show()