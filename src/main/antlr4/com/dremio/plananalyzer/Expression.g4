grammar Expression;

expr: expression EOF;

expression: atom (('(' expression (COMMA expression)* ')' | '(' ')')? typeSuffix?)? | '[' expression ']';

typeSuffix: (':' type charset?);

charset: (ID | STRING)+;

type: expression;

atom: (
    NUMBER
    | DATE
    | DOLLARV
    | (ID | STRING)+
    | ('>' | '>=' | '=' | '<' | '<=' | '<>' | '||')
    | ('+'|'-'|'*'|'/')
    | 'DISTINCT' DOLLARV
) ;

// Tokens
SPACE  : [ \t\r\n]+ -> skip ;
ID: ALPHA(ADD)* | DIGIT+(ALPHA[$])+(ADD)+ | '`' ~[`]+ '`';
NUMBER: '-'? DIGIT+ ('.' DIGIT+)? ('E''-'?DIGIT+)?;
STRING: '"' ('"' | ~["]+ '"') | '\'' ('\'' | ~[']+ '\'');
DOLLARV: '$' (NUMBER | ID)+;
DATE: DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT;
COMMA: ',';
//NL   : '\r' '\n' | '\n' | '\r';
fragment ADD: [a-zA-Z0-9_$];
fragment ALPHA: [a-zA-Z_];
fragment DIGIT  : [0-9];
