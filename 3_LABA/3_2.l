%{
    #include <stdio.h>
    #include <string.h>
    #include "3_2.tab.h"
    void erorr();
    %}
%%
"+"     { return SUM;}
"-"     { return MIN; }
"*"     { return MULT; }
"/"     { return DEL; }
[0-9]+  { yylval=atoi(yytext); return INTEGER; }
"("     {return prSKOBKA;}
")"     {return levSKOBKA;}
"="     {return RAVNO;}
[/t] + ;
.       {erorr();}
%%
int yylex(void);
void yyerror(const char *str){
    fprintf(stderr,"Error: %s\n",str);
}
int yywrap(){
    return 1;
}
int main(int argc, char **argv) {
    yyparse();
}
void error(){
    printf("Erorr");
}