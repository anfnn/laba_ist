#include <stdio.h> 
#include <stdlib.h>
void main(int args, char *argm[]) {
    

    FILE *file = fopen(argm[1], "read");
    if (file == NULL) {
        perror("Ошибка");
    }

   
    char line[1024]; 
    while (fgets(line, sizeof(line), file)) {
        printf("%s", line);
    }

    
    fclose(file);

}