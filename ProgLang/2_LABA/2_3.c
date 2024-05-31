#include <stdio.h>
#include <ctype.h>

struct products
{
    char name[100];
    double price;
};

int chislo_strok(char *filename){
    FILE *file = fopen(filename, "r");
    int count = 0;
    if (file == NULL) {
        // Обработка ошибки при открытии файла
        return -1;  // Возвращаем код ошибки 
    }else{
        char sym;
        while ((sym = fgetc(file)) != EOF) {
            if (sym == '\n') {
                count++;
                }
            }
        }

    fclose(file);
    return count;
}

void sort ( struct products mas[]){
    int len = chislo_strok ("2_3.txt");
    struct products per;
    for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (mas[j].price > mas[j + 1].price) {
                    per = mas[j];
                    mas[j] = mas[j + 1];
                    mas[j + 1] = per;
                }
            }
    }
}

void main(){
    int chislo = chislo_strok ("2_3.txt");
    struct products mas[chislo];
    FILE *file = fopen("2_3.txt", "r");
    if (file == NULL) {
         perror("Ошибка открытия файла!");
    } else{
        for (int i = 0 ; i < chislo; i ++){
            fscanf(file, "%100s %lf", mas[i].name, & mas[i].price);

        }
        fclose(file);
    }
    file = fopen("2_31.txt","w");
    sort(mas);
    if (file == NULL) {
        perror("Ошибка открытия файла!");
    } else {
    //запись отсортированных данных в файл
    for (int i = 0; i < chislo; i++) {
            fprintf(file, "%s %.2f\n", mas[i].name, mas[i].price);
    	}
	}
    fclose(file);
}