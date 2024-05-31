"""
Решение ДУ методом Эйлера
    Параметры:
    - f: функция правой части дифференциального уравнения
    - x0: начальное значение x
    - v0: начальное значение производной x (x')
    - t0: начальное значение t
    - tn: конечное значение t
    - h: шаг по времени

    Возвращает:
    - t_values: список значений t
    - x_values: список значений x
"""


import numpy as np
import matplotlib.pyplot as plt

"""Аналитическое решение ДУ"""
def analitic1(t):
    return np.sin(t)

def analitic2(t):
    return t

def analitic3(t):
    return 3*np.sin(t)/2 - t * np.cos(t)/2

"""Метод Эйлера"""
def euler_method(f, x0, v0, t0, tn, h):

    # Список для хранения значений x и v
    x_values = [x0]
    v_values = [v0]
    t_values = [t0]

    # Цикл метода Эйлера
    while t_values[-1] < tn:
        t = t_values[-1]
        x = x_values[-1]
        v = v_values[-1]

        # Вычисляем производную
        dxdt = v
        dvdt = f(t, x)

        # Обновляем значения методом Эйлера
        x_new = x + h * dxdt
        v_new = v + h * dvdt
        t_new = t + h

        # Добавляем новые значения в списки
        x_values.append(x_new)
        v_values.append(v_new)
        t_values.append(t_new)

    return t_values, x_values


# Функции для дифференциальных уравнений
def f1(t, x):
    return -x


def f2(t, x):
    return t - x


def f3(t, x):
    return np.sin(t) - x


# Начальные условия
x0 = 0
v0 = 1
t0 = 0
tn = 50
h = 0.1

# Вычисляем значения методом Эйлера для каждого уравнения
t_values, x_values1 = euler_method(f1, x0, v0, t0, tn, h)
t_values, x_values2 = euler_method(f2, x0, v0, t0, tn, h)
t_values, x_values3 = euler_method(f3, x0, v0, t0, tn, h)

# Вычисляем значения аналитических функций
analitic_values1 = analitic1(np.array(t_values))
analitic_values2 = analitic2(np.array(t_values))
analitic_values3 = analitic3(np.array(t_values))

# Строим графики
plt.figure(figsize=(10, 6))
plt.subplot(3, 1, 1)
plt.plot(t_values, x_values1 - analitic_values1, label="x''(t) + x(t) = 0")
plt.legend()

plt.subplot(3, 1, 2)
plt.plot(t_values, x_values2 - analitic_values2, label="x''(t) + x(t) = t")
plt.legend()

plt.subplot(3, 1, 3)
plt.plot(t_values, x_values3 - analitic_values3, label="x''(t) + x(t) = sin(t)")
plt.legend()

plt.show()
