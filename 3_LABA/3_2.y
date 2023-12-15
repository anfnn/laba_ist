%{
#include <stdio.h>
#include <string.h>
#include "3_2.tab.h"

int yylex(void);
void yyerror(const char *str);
int main(int argc, char **argv);
%}

%token SUM MIN MULT DEL
%token INTEGER
%token prSKOBKA levSKOBKA
%token RAVNO

%%

calclist: 
| calclist exp RAVNO { printf("= %d\n", $2); }
;

exp: vtorich
| exp SUM vtorich { $$ = $1 + $3; }
| exp MIN vtorich { $$ = $1 - $3; }
;

vtorich: pervich
| vtorich MULT pervich { $$ = $1 * $3; }
| vtorich DEL  pervich  { $$ = $1 / $3; }
;

pervich: INTEGER
| prSKOBKA exp levSKOBKA { $$ = $2 ; } 
;

%%

void yyerror(const char *str){
    fprintf(stderr,"Error: %s\n",str);
}

int main(int argc, char **argv){
  yyparse();
  return 0;
}
