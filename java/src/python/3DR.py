from mpl_toolkits.mplot3d import Axes3D
import numpy as np
from matplotlib import pyplot as plt

# fig = plt.figure()
#
# ax = fig.add_subplot(111, projection='3d')
# t=np.arange(-2*np.pi,2*np.pi,0.1)
# s=np.arange(-2*np.pi,2*np.pi,0.1)
#
# X = 3*np.cos(t)+np.cos(t)*np.cos(s)
# Y = 3*np.sin(t)+np.sin(t)*np.cos(s)
# Z = np.sin(t)
#
# # X, Y = np.meshgrid(t, s)#网格的创建，这个是关键
# # plt.xlabel('x')
# # plt.ylabel('y')
# ax.plot_surface(X, Y, Z)


fig = plt.figure()
ax = fig.add_subplot(111, projection='3d')

# Make data
u=np.arange(-200*np.pi,200*np.pi,0.1)
v=np.arange(-200*np.pi,200*np.pi,0.1)
# x = 10 * np.outer(np.cos(u), np.sin(v))
# y = 10 * np.outer(np.sin(u), np.sin(v))
# z = 10 * np.outer(np.ones(np.size(u)), np.cos(v))
x = 3*np.cos(u)+np.cos(u)*np.cos(v)
y = 3*np.sin(u)+np.sin(u)*np.cos(v)
z = np.sin(v)
# Plot the surface

ax.plot_trisurf(x, y, z)
plt.show()