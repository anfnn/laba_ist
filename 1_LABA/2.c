#include <stdio.h>
int main(){
    double a,b,c,x;
    printf("vvedite a");
    scanf("%lf", &a);
    printf("vvedite b");
    scanf("%lf", &b);
    printf("vvedite c");
    scanf("%lf", &c);
    x = (c-b)/a;
    printf("x = %lf\n",x);
    return 0;
}
