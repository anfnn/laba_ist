'''
Составить программу, решающая матрицу методом Гаусса
def Gauss(a,b): функция, выполняющая метод Гаусса
'''
import numpy as np

def Gauss(a,b):
    n = len(b)

    for k in range (0,n-1):
        for i in range(k+1,n):
            if a[i,k] != 0:
                lam = a[i,k]/a[k,k]
                a[i,k+1:n] = a[i,k+1:n] - lam*a[k,k+1:n]
                b[i] = b[i] - lam*b[k]
    for k in range(n-1,-1,-1):
        b[k] = (b[k] - np.dot(a[k,k+1:n],b[k+1:n]))/a[k,k]
    return b

A = np.array([[4.0,-2.0,1.0],[-2.0,4.0,-2.0],[1.0,-2.0,4.0]])
B = np.array([11.0,-16.0,17.0])
print(A)
print(B)
result = Gauss(A,B)
print(result)

