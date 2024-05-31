# Реализовать 2 метода численного диффференцирования
import numpy as np
import matplotlib.pyplot as mathplot

'''
def parametric_function(t):
    x = 2 * np.sin(2* t)
    y = 2 * np.cos(t)
    return x, y
'''

def graph(x,y): # определяем функцию graph, которая принимает на вход массивы x и y
    mathplot.plot(x, y) #график y от x
    mathplot.title('График функции')
    mathplot.xlabel('x')
    mathplot.ylabel('y')
    mathplot.grid(True)
    mathplot.show()

def func(t): # определяем функцию func, которая принимает на вход параметр t
    return np.cos(t)

def Right_derivative(t, h): # вычисляет правую производную
    return (func(t+h) - func(t)) / h

def Left_derivative(t, h): # вычисляет левую производную
    return (func(t) - func(t-h)) / h

def Total_derivative(t , h): # вычисляет полную производную
    return (func(t + h) - func(t - h)) / (2 * h)

def Sec_Order_derivative(t, h): # вычисляет вторую производную
    return (func(t - h) - 2 * func(t) + func(t + h)) / (h ** 2)

def Accurate_Total_derivative(t): # возвращает точное значение полной производной
    return -np.sin(t)

def Accurate_Sec_Order_derivative(t): # возвращает точное значение второй производной
    return  -np.cos(t)


# Задаем диапазон параметра t
h = 10**-3
t = np.linspace(0, 2 * np.pi, 100)
graph(t, Accurate_Sec_Order_derivative(t) - Sec_Order_derivative(t, h))
