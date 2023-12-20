%{
    #include <stdio.h>
    #include <string.h>
    #include "3_3.tab.h"
    void exit_ctrlq();
    void error();
%}
%option noyywrap

%%

[0-9]+(\.[0-9]+)? { yylval.number=atof(yytext); return NUM; }
[-+*/(){}]        {return yytext[0]; } 
[\n]              { return RAVNO;}
[ \t]  /* skip whitespaces */
":exit"           {exit_ctrlq();}
.                 {error();}
%%

void error(){
    printf("Error");
}
void exit_ctrlq(){
    exit(0);
}
