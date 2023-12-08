#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int sizeofNum(int num){ //Счетчик цифр в числе
	int numb = num;
	int count = 0;
    while(numb != 0){
    	numb /= 10;
    	count++;
    }
    return count;
}
int main() {
int i;
int len,num;
int* mas = (int*)malloc(len*sizeof(int));
printf("vvedite dlinu ");
scanf("%d", &len);
for(i = 0; i < len; i++) {
    num = rand();
    mas[i] = num;
    printf("%d ", num);
}

 FILE *file = fopen("2_1.txt", "w"); 
    if (file == NULL) {
        perror("Ошибка открытия файла!");
    } else {
        //Считывание данных с массива в обратном порядке
        for(int i = len-1; i >= 0; i--){
            //Счетчик цифр в числе
            int count = sizeofNum(mas[i]);
            //Перевод числа mas[i] в массив символов num_char
            char num_char[count];
            sprintf(num_char, "%d", mas[i]);
            //Посимвольная запись чисел в файл
            for (int j = 0; j < count; j++){
                fputc(num_char[j],file);
            }
			fprintf(file, "\n");
        }
    }
    fclose(file);
    free(mas);
}
