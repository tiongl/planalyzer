grammar Expression;

expr: expression EOF;

expression: atom (('(' expression (COMMA expression)* ')')? (':' type charset?)?)? | '[' expression ']';

charset: (ID | STRING)+;

type: expression;

atom: (
    NUMBER
    | DOLLARV
    | (ID | STRING)+
    | ('>' | '>=' | '=' | '<' | '<=' | '<>' | '||')
    | ('+'|'-'|'*'|'/')
) ;

// Tokens
SPACE  : [ \t\r\n]+ -> skip ;
ID: ALPHA(ADD)* | DIGIT+(ALPHA[$])+(ADD)+ | '`' ~[`]+ '`';
NUMBER: '-'? DIGIT+ ('.' DIGIT+ ('E'DIGIT+)?)?;
STRING: '"' ('"' | ~["]+ '"') | '\'' ('\'' | ~[']+ '\'');
DOLLARV: '$' (NUMBER | ID)+;
COMMA: ',';
//NL   : '\r' '\n' | '\n' | '\r';
fragment ADD: [a-zA-Z0-9_$];
fragment ALPHA: [a-zA-Z_];
fragment DIGIT  : [0-9];
