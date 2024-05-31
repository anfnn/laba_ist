""" Составить 3 сортировки тремя разными способами
 В качестве способов сортировки были выбраны:
 Сортировка подсчётом (def counting_sort)
 Сортировка пузырьком (def bubble_sort)
 Сoртировка слиянияем (def merge_sort)
 """

from random import randint

# Функция сортировки подсчётом (Counting Sort)
def counting_sort(alist, largest):
    c = [0] * (largest + 1)
    for i in range(len(alist)):
        c[alist[i]] = c[alist[i]] + 1

    # Нахождение последнего индекса для каждого элемента
    c[0] = c[0] - 1  # для уменьшения каждого элемента из-за индексации с нуля
    for i in range(1, largest + 1):
        c[i] = c[i] + c[i - 1]

    result = [None] * len(alist)

    # Разворачиваем список для устойчивой сортировки
    for x in reversed(alist):
        result[c[x]] = x
        c[x] = c[x] - 1

    return result

# Функция сортировки пузырьком (Bubble Sort)
def bubble_sort(lst):
    n = len(lst)
    for i in range(n):
        for j in range(0, n - i - 1):
            if lst[j] > lst[j + 1]:
                lst[j], lst[j + 1] = lst[j + 1], lst[j]
    return lst

# Функция сортировки слиянием (Merge Sort)
def merge_sort(alist, start, end):

    if end - start > 1:
        mid = (start + end) // 2  # Находим середину списка
        merge_sort(alist, start, mid)  # Рекурсивно сортируем левую часть списка
        merge_sort(alist, mid, end)  # Рекурсивно сортируем правую часть списка
        merge_list(alist, start, mid, end)  # Объединяем отсортированные части списка

# Вспомогательная функция для сортировки слиянием
def merge_list(alist, start, mid, end):
    left = alist[start:mid]  # Создание подсписка слева от середины
    right = alist[mid:end]   # Создание подсписка справа от середины
    k = start  # Индекс начала сортированной зоны
    i = 0  # Индекс для подсписка left
    j = 0  # Индекс для подсписка right
    while (start + i < mid and mid + j < end):
        if (left[i] <= right[j]):
            alist[k] = left[i]  # Помещаем элемент из left в список
            i = i + 1
        else:
            alist[k] = right[j]  # Помещаем элемент из right в список
            j = j + 1
        k = k + 1
    if start + i < mid:
        while k < end:
            alist[k] = left[i]  # Добавляем оставшиеся элементы из left в список
            i = i + 1
            k = k + 1
    else:
        while k < end:
            alist[k] = right[j]  # Добавляем оставшиеся элементы из right в список
            j = j + 1
            k = k + 1  # Помещение отсортированных элементов обратно в основной список

# Исходный список для сортировки
alist = [5, 6, 8, 1, 2, 3, 4, 5, 5]
alist2 = alist
alist3 = alist
alist = [int(x) for x in alist]

# Выполнение сортировки слиянием и вывод результата
merge_sort(alist, 0, len(alist))
print('Сортировка слиянием: ', end='')
print(alist)

# Выполнение сортировки пузырьком и вывод результата
print('Сортировка пузырьком: ', end='')
print(bubble_sort(alist2))

alist3 = [int(x) for x in alist3]
k = max(alist3)

# Выполнение сортировки подсчётом и вывод результата
sorted_list = counting_sort(alist3, k)
print('Сортировка подсчётом: ', end='')
print(sorted_list)  # Опечатка: не закрыта скобка в этой строке
