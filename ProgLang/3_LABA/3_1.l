%{
#include <stdio.h>
void erorr();
void exitt();
  %}

%%
[0-9] + {printf("Int number");}
[a-zA-Z]       {printf("Letter");}
[a-zA-Z]+      {printf("Words");}
[0-9] + \.[0-9] {printf("float/ double  number");}

"+"     { printf("Plus operator\n"); }
"-"     { printf("Minus operator\n"); }
.       { printf("Unexpected character: %s\n", yytext); }
"*"     { printf("Multi operator\n"); }
"/"     { printf("del operator\n"); }
[/t] + ;
.       {erorr();}
"end"   {exitt();}
%%
void erorr(){
    printf("There is a erorr");

}
void exitt(){
    exit(0);

}
