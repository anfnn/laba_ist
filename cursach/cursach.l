%{
 
   #include <stdio.h>
   #include <stdlib.h>
   #include"cursach.tab.h"
   #include <math.h>
   extern int yylval;
 
%}

%%
[0-9]+  {  yylval=atoi(yytext); return VAL; }
jumpd return JUMP_DOWN;
jumpr return JUMP_RIGHT;
jumpup return JUMP_UP;
jumpl return JUMP_LEFT;
right return RIGHT;
left return LEFT;
up return UP;
down return DOWN;
t1 return T1;
t2 return T2;
 
"exit"   { return EXIT; }
\n
[ \t]+ ;
 
%%
int yywrap() {
    return 1;
}
