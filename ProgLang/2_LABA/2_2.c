#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
    srand(time(NULL));
    int i;
    int j;
    int len;
    float num;
    float temp;
    float* mas = (float*)malloc(len*sizeof(float));
    printf("vvedite dlinu ");
    scanf("%d", &len);
    for(i = 0; i < len; i++) {
        num = (float)rand() / RAND_MAX;
        mas[i] = num;
    }

    for (i = 0; i < len - 1; i++) {
            for (j = 0; j < len - i - 1; j++) {
                if (mas[j] > mas[j + 1]) {
                    temp = mas[j];
                    mas[j] = mas[j + 1];
                    mas[j + 1] = temp;
                }
            }
        }

        // Вывод отсортированного массива
    for (i = 0; i < len; i++) {
        printf("%f ", mas[i]);
        }
        
    FILE *file = fopen("2_2.txt", "w"); 
    if (file == NULL) {
        perror("Ошибка открытия файла!");
        return 1;
    } else {
            for (i = 0; i < len; i++) {
            fprintf(file, "%f\n", mas[i]);
        }
        fclose(file);
        printf("Массив успешно записан в файл.\n");
    }
    free(mas);
    return 0;
}

