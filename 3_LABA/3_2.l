%{
    #include <stdio.h>
    #include <string.h>
    #include "3_2.tab.h"
    void error();
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

.       {error();}
%%

int yywrap(){
    return 1;
}

void error(){
    printf("Error");
}
