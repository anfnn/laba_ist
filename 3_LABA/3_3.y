%{
#include <stdio.h>
#include <string.h>
#include "3_3.tab.h"

int yylex(void);
void yyerror(const char *str);
%}

%union {
    double number;
} 

%token <number> NUM
%token RAVNO

%left "+"  "-"
%left "*"  "/"
%%

postf: 
| postf exp RAVNO { printf("= \n"); }
;

exp: vtorich
| exp '+' vtorich { printf("+"); }
| exp '-' vtorich { printf("-"); }
;

vtorich: pervich
| vtorich '*' pervich { printf("*"); }
| vtorich '/'  pervich { printf("/"); }
;

pervich: NUM { printf("%.2f ", $1); }
| '(' exp ')' {} 
;

%%

void yyerror(const char *str){
    fprintf(stderr,"Error: %s\n",str);
}

int main(int argc, char **argv){
  yyparse();
  return 0;
}
