#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

// Структура для элемента стека
typedef struct Node {
    int value;
    struct Node* prev;
} Node;

// Глобальный указатель на вершину стека
struct Stack {
    struct Node* top;
};

// Функция для создания пустого стека
struct Stack* createStack() {
    struct Stack* stack = (struct Stack*)malloc(sizeof(struct Stack));
    stack->top = NULL;
    return stack;
}

// Функция для добавления значения в стек
void push(struct Stack* stack, int value) {
    // Создаем новый узел для значения
    Node* newNode = (Node*)malloc(sizeof(Node));
    if (newNode == NULL) {
        // Обработка ошибки при переполнении стека
        printf("Ошибка: переполнение стека\n");
        return;
    }
    
    // Заполняем данные нового узла
    newNode->value = value;
    newNode->prev = stack->top;
    
    // Обновляем указатель на вершину стека
    stack->top = newNode;
    
    printf("Значение %d добавлено в стек\n", value);
}

// Функция для извлечения значения из стека
int pop(struct Stack* stack) {
    if (stack->top == NULL) {
        // Обрабатываем ошибку при попытке извлечения из пустого стека
        printf("Ошибка: стек пуст\n");
        return -1;
    }
    
    // Получаем значение верхнего элемента
    int value = stack->top->value;
    
    // Обновляем указатель на вершину стека
    Node* prevTop = stack->top;
    stack->top = stack->top->prev;
    
    // Освобождаем память, занятую предыдущим верхним элементом
    free(prevTop);
    
    return value;
}

// Функция для просмотра верхнего значения стека
int peek(struct Stack* stack) {
    if (stack->top == NULL) {
        // Обрабатываем ошибку при попытке просмотра пустого стека
        printf("Ошибка: стек пуст\n");
        return -1;
    }
    
    return stack->top->value;
}

int main() {
    FILE *file = fopen("2_5.txt", "r");

    if (file == NULL) {
        printf("Ошибка при открытии файла\n");
        return -1;
    }

    struct Stack* stack = createStack();

    char c;
    while ((c = fgetc(file)) != EOF) {
        if (isdigit(c)) {
            push(stack, c - '0');
        } else if (c == '+' || c == '-' || c == '*' || c == '/') {
            int operand2 = pop(stack);
            int operand1 = pop(stack);

            switch (c) {
                case '+':
                    push(stack, operand1 + operand2);
                    break;
                case '-':
                    push(stack, operand1 - operand2);
                    break;
                case '*':
                    push(stack, operand1 * operand2);
                    break;
                case '/':
                    push(stack, operand1 / operand2);
                    break;
            }
        }
    }

    fclose(file);

    if (stack->top != NULL) {
        int result = pop(stack);
        printf("Результат: %d\n", result);
    } else {
        printf("Ошибка: стек пуст\n");
    }

    free(stack);

    return 0;
}