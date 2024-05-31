#include <stdio.h>
#include <stdlib.h>

// Структура для элемента стека
typedef struct Node {
    int value;
    struct Node* prev;
} Node;

// Глобальный указатель на вершину стека
Node* top = NULL;

// Функция для добавления значения в стек
void push(int value) {
    // Создаем новый узел для значения
    Node* newNode = (Node*)malloc(sizeof(Node));
    if (newNode == NULL) {
        // Обработка ошибки при переполнении стека
        printf("Ошибка: переполнение стека\n");
        return;
    }
    
    // Заполняем данные нового узла
    newNode->value = value;
    newNode->prev = top;
    
    // Обновляем указатель на вершину стека
    top = newNode;
    
    printf("Значение %d добавлено в стек\n", value);
}

// Функция для извлечения значения из стека
int pop() {
    if (top == NULL) {
        // Обрабатываем ошибку при попытке извлечения из пустого стека
        printf("Ошибка: стек пуст\n");
        return -1;
    }
    
    // Получаем значение верхнего элемента
    int value = top->value;
    
    // Обновляем указатель на вершину стека
    Node* prevTop = top;
    top = top->prev;
    
    // Освобождаем память, занятую предыдущим верхним элементом
    free(prevTop);
    
    return value;
}

// Функция для просмотра верхнего значения стека
int peek() {
    if (top == NULL) {
        // Обрабатываем ошибку при попытке просмотра пустого стека
        printf("Ошибка: стек пуст\n");
        return -1;
    }
    
    return top->value;
}

int main() {
    // Пример использования функций для работы со стеком
    
    // Добавляем значения в стек
    push(5);
    push(10);
    push(15);
    
    // Просматриваем верхнее значение стека
    printf("Верхнее значение стека: %d\n", peek());
    
    // Извлекаем значения из стека
    int value1 = pop();
    int value2 = pop();
    int value3 = pop();
    
    // Выводим извлеченные значения
    printf("Извлеченные значения: %d, %d, %d\n", value1, value2, value3);
    
    // Пытаемся извлечь значение из пустого стека
    int value4 = pop();
    
    return 0;
}