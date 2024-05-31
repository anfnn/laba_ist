#include <stdio.h>

void main(int argst, char *argm[]){
    FILE *file = fopen(argm[1], "r");// открытие файла для чтения
    if (file == NULL) {
        perror("Ошибка при открытии файла");// Сообщение об ошибке при открытии файла
    }
    // Определение количества строк и их длины
    int shstr = 0;// Счетчик количества строк
    int lenstr = 0;// Переменная, хранящая максимальную длину строки, содержащейся в файле, для создания массива для хранения этих строк
    while (!feof(file)){// Перебор строк в файле до конца файла
        if (fgetc(file) == '\n'){// Проверка на символ, указывающий на конец строки(\n)
            shstr++;
        }else{
            lenstr++;
        }
    }

    // Запись  файла в массив
    int j = 0;
    char massiv[shstr][lenstr];// Создание массива для хранения строк
    fseek(file, 0, SEEK_SET);// Возврат в начало файла
    while(!feof(file)){
        fgets(massiv[j], lenstr-1, file);
        j++;
    }
    fclose(file);// Закрытие файла

    file = fopen(argm[1], "w");// Открытие файла для записи
    printf("Введите текст\n");
    char newtext[256];// Массив, хранящий введенный с клавиатуры текст
    fgets(newtext, 256, stdin);// Заполнение массива
    fputs(newtext, file);// Добавление данных из массива в файл

    //Запись в файл новых строк
    for (int i = 0; i< shstr; i++){
        fputs(massiv[i], file);
    }
    fclose(file);
}
