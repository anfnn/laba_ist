%{
#include <stdio.h>
#include <string.h>
#include "3_2.tab.h"
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

