grammar ProjectField;

expr: fieldsets EOF;

fieldsets: '[' fieldset (',' fieldset)* ']';

fieldset: '{' (NUMBER (',' NUMBER) *)? '}';

// Tokens
SPACE  : [ \t\r\n]+ -> skip ;
NUMBER: DIGIT+;
fragment DIGIT  : [0-9];
