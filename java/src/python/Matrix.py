# encoding: utf-8
import numpy as np
from sympy import Matrix
from sympy.matrices import dense

#
a = np.arange(0, 9).reshape(3, 3)

#print(a)
b = np.einsum('ij->ji', a)
#print(b)

A = [[2,5],
     [1,3]];
B = [[4,-6],
     [2,1]];
X = np.dot(A,B)
print(X)
X = np.multiply(A,B)
print(X)
print("矩阵行列式|A| \n", np.linalg.det(A))
print("矩阵行列式|B| \n", np.linalg.det(B))
print("矩阵行列式|X| \n", np.linalg.det(X))
X = np.linalg.solve(A, B)
print(X)
print("矩阵的行列式值|A|：\n",np.linalg.det(A))
A = [[1,2,1,0],
     [0,1,0,1],
     [0,0,2,1],
     [0,0,0,3]]
print(np.transpose(A))
print("转置矩阵A^T：\n",np.transpose(A)); # 转置
print("矩阵的行列式值|A|：\n",np.linalg.det(A)); # 方阵的行列式值：|A|
print("矩阵的迹trace(A)：\n",np.trace(A));
print("矩阵的秩rank(A)：\n",np.linalg.matrix_rank(A));

print("逆矩阵A^(-1)：\n",np.linalg.inv(A));

A = [[1,2,3],
     [2,2,5],
     [3,5,1]]
B = [[1],[2],[3]]

print("求解AX=b中的未知参数矩阵X\n",X);

# Matrix convert to array
A_mat = Matrix([[1, 2, 1, 1], [2, 1, -2, -2], [1, -1, -4, 3]])
A_arr1 = np.array(A_mat.tolist()).astype(np.int32)
A_arr2 = dense.matrix2numpy(A_mat, dtype=np.int32)


# array convert to Matrix
B_arr = np.array([[1, 2, 1, 1], [2, 1, -2, -2], [1, -1, -4, 3]])
B_mat = Matrix(B_arr)

# RREF
# A_rref = np.array(A.rref()[0].tolist()).astype(np.int32)
# B_rref = (Matrix(B_arr).rref()[0].tolist()).astype(np.int32)
M = Matrix([[2,3],[-1,2]])
print(M)
print("计算M特征值")
print(M.eigenvals())
print("计算M特征向量")
print(M.eigenvects())
M = Matrix([[3,-1],[-1,3]])
print(M)
print("计算M特征值")
y = M.eigenvals()
print(y)
print("计算M特征向量")
print(M.eigenvects())