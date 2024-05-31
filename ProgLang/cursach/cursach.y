%{
#include <stdio.h>
#include <stdlib.h>
#include"cursach.tab.h"
extern FILE *yyin, *yyout;

void yyerror();
int yylex(void);
int x;  // начальная координата по оси x
int y;  // начальная координата по оси y
int counter = 0;  // счетчик выполненных действий
%}


%token VAL UP DOWN RIGHT LEFT EXIT T1 T2 JUMP_DOWN JUMP_LEFT JUMP_RIGHT JUMP_UP
%left '+' '-'
%left '*' '/'
%left '(' ')'

%%

commands: //описывает последовательность команд
        | commands command
        ;

command: movement  // движение
        | exit  // выход
        | action  // действие
        | jump  // прыжок
        ;
		// command  представляет собой 4 типа команд : movement, exit,action,jump

movement: UP VAL {  // движение вверх на заданное количество шагов
    y = y + $2;
    if (y > 100 || y < 0) {
        fprintf(yyout, "Невозможное действие: превышение границы по оси y\n");
        exit(0);
    } else {
        counter = counter + $2;
        fprintf(yyout, "Робот движется вверх на %d шагов\n", $2);
        fprintf(yyout, "Координата x = %d\n", x);
        fprintf(yyout, "Координата y = %d\n\n", y);
    }
}
         | DOWN VAL {  // движение вниз на заданное количество шагов
    y = y - $2;
    if (y < 0 || y > 100) {
        fprintf(yyout, "Невозможное действие: превышение границы по оси y\n");
        exit(0);
    } else {
        counter = counter + $2;
        fprintf(yyout, "Робот движется вниз на %d шагов\n", $2);
        fprintf(yyout, "Координата x = %d\n", x);
        fprintf(yyout, "Координата y = %d\n\n", y);
    }
}
         | RIGHT VAL {  // движение вправо на заданное количество шагов
    x = x + $2;
    if (x > 100 || x < 0) {
        fprintf(yyout, "Невозможное действие: превышение границы по оси x\n");
        exit(0);
    } else {
        counter = counter + $2;
        fprintf(yyout, "Робот движется вправо на %d шагов\n", $2);
        fprintf(yyout, "Координата x = %d\n", x);
        fprintf(yyout, "Координата y = %d\n\n", y);
    }
}
         | LEFT VAL {  // движение влево на заданное количество шагов
    x = x - $2;
    if (x < 0 || x > 100) {
        fprintf(yyout, "Невозможное действие: превышение границы по оси x\n");
        exit(0);
    } else {
        counter = counter + $2;
        fprintf(yyout, "Робот движется влево на %d шагов\n", $2);
        fprintf(yyout, "Координата x = %d\n", x);
        fprintf(yyout, "Координата y = %d\n\n", y);
    }
};

exit: EXIT {  // выход из программы
    fprintf(yyout, "Программа завершена!\n");
};

action: T1 {  // действие 1
    fprintf(yyout, "Робот кладет первый кубик\n");
    fprintf(yyout, "Координата x = %d\n", x);
    fprintf(yyout, "Координата y = %d\n\n", y);
    counter++;
}
       | T2 {  // действие 2
    fprintf(yyout, "Робот кладет второй кубик\n");
    fprintf(yyout, "Координата x = %d\n", x);
    fprintf(yyout, "Координата y = %d\n\n", y);
    counter++;
};

jump: JUMP_UP VAL {  // прыжок вверх на заданное количество шагов
    y = y + (2 * $2);
    if (y > 100 || y < 0) {
        fprintf(yyout, "Невозможное действие: превышение границы по оси y\n");
        exit(0);
    } else {
        counter = counter + (2 * $2);
        fprintf(yyout, "Робот прыгает вверх на %d шагов\n", (2 * $2));
        fprintf(yyout, "Координата x = %d\n", x);
        fprintf(yyout, "Координата y = %d\n\n", y);
    }
}
     | JUMP_DOWN VAL {  // прыжок вниз на заданное количество шагов
    y = y - (2 * $2);
    if (y < 0 || y > 100) {
        fprintf(yyout, "Невозможное действие: превышение границы по оси y\n");
        exit(0);
    } else {
        counter = counter + (2 * $2);
        fprintf(yyout, "Робот прыгает вниз на %d шагов\n", (2 * $2));
        fprintf(yyout, "Координата x = %d\n", x);
        fprintf(yyout, "Координата y = %d\n\n", y);
    }
}
     | JUMP_RIGHT VAL {  // прыжок вправо на заданное количество шагов
    x = x + (2 * $2);
    if (x > 100 || x < 0) {
        fprintf(yyout, "Невозможное действие: превышение границы по оси x\n");
        exit(0);
    } else {
        counter = counter + (2 * $2);
        fprintf(yyout, "Робот прыгает вправо на %d шагов\n", (2 * $2));
        fprintf(yyout, "Координата x = %d\n", x);
        fprintf(yyout, "Координата y = %d\n\n", y);
    }
}
     | JUMP_LEFT VAL {  // прыжок влево на заданное количество шагов
    x = x - (2 * $2);
    if (x < 0 || x > 100) {
        fprintf(yyout, "Невозможное действие: превышение границы по оси x\n");
        exit(0);
    } else {
        counter = counter + (2 * $2);
        fprintf(yyout, "Робот прыгает влево на %d шагов\n", (2 * $2));
        fprintf(yyout, "Координата x = %d\n", x);
        fprintf(yyout, "Координата y = %d\n\n", y);
    }
};

%%

void main() {
    yyin = fopen("cursach_int.txt", "r");
    yyout = fopen("cursach_out.txt", "w");
    scanf("%d", &x);  // ввод начальной координаты x
    scanf("%d", &y);  // ввод начальной координаты y

    fprintf(yyout, "Начальные координаты робота:\nКоордината x = %d\nКоордината y = %d\n", x, y);

    fprintf(yyout, "\n");
    yyparse();
    fprintf(yyout, "Конечная координата робота x = %d\n", x);
    fprintf(yyout, "Конечная координата робота y = %d\n", y);

    fprintf(yyout, "Количество выполненных действий: %d\n", counter);
    fprintf(yyout, "\n");
}

void yyerror() {
    printf("\nВыражение недопустимо\n");
}