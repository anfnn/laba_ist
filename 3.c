#include <stdio.h>
void main(int argum, char *armas[]){
        printf("Kolichestvo argumentov: %d\n", argum);
        for ( int i = 0;i< argum ;i++){
            printf("Argument %d: %s\n", i ,armas[i]);
            }
    }