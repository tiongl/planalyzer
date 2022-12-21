grammar Plan;

//@members {
//    java.util.Stack<Integer> levels = new java.util.Stack<Integer>();
//}

expr: planLine (planLine)* EOF;

planLine:  (PHASE { levels.push($PHASE.text.length()); } planName  ':' rowType ':' costList
            /*
            //The following try to establish the hierarchy but it doesn't work due to Antlr limitation
            (
                //can't really do this - StackOverflow easily
               { _input.LA(1)==PHASE && _input.LT(1).getText().length()>levels.peek().intValue()
            }?
            childPlan)*
            ) { levels.pop(); }
            */
                ;

//childPlan:  'ZZZZ' planLine; //can't get the Semantic Predicate in planLine to work - adding ZZZZ to bypass this.

//Screen line
planName: ID eqList?;

//RowType
rowType: 'rowType' '=' recordType;
recordType: 'RecordType' '(' typeList ')';
typeList: typePair (',' typePair)*;
typePair: type typeID;
type: (
    ID ( '(' NUMBER (',' NUMBER)? ')' ('ARRAY'| characterset)?)?
    | recordType
);

characterset: 'CHARACTER' 'SET' STRING 'COLLATE' STRING 'NOT' 'NULL';

//Cost
costList: costPair (COMMA costPair)* ;
costPair: ID ID? '=' cost;
cost: (NUMBER | cumulativeCost);
cumulativeCost: '{' cumuCost (COMMA cumuCost)* '}';
cumuCost: NUMBER ID;



eqList: '(' eqPair (COMMA eqPair)* ')';
eqPair: eqID ( '=' eqValue | eqValue); //eqValue directly is because eqId like '<=', '>=' etc
eqID:  (
    ID+
    | DOLLARV
    | ('>' | '>=' | '=' | '<' | '<=' | '<>' | '+' | '-' | '*' | '/') NUMBER?
);
eqValue: (
    BRACKET_STUFF
);

typeID:  (
    DOLLARV
    | ID
    | ('>' | '>=' | '=' | '<' | '<=' | '<>' | '+' | '-' | '*' | '/') NUMBER?
);

// Keywords
SPACE  : [ \t\r\n]+ -> skip ;

// Tokens
PHASE: DIGIT+ '-' DIGIT+ ' '+;
BRACKET_STUFF: '[' (~[[\]'"\n\r]+ | BRACKET_STUFF | STRING)+ ']';
ID: ALPHA(ADD)* | DIGIT+(ALPHA[$])+(ADD)+ | '`' ~[`]+ '`';
NUMBER: '-'? DIGIT+ ('.' DIGIT+ ('E'DIGIT+)?)?;
STRING: '"' ('"' | ~["]+ '"') | '\'' ('\'' | ~[']+ '\'');

//UUID: [0-9a-zA-Z]+;
DOLLARV: '$' (NUMBER | ID)+;
COMMA: ',';
NL   : '\r' '\n' | '\n' | '\r';
fragment ADD: [a-zA-Z0-9_$];
fragment ALPHA: [a-zA-Z_];
fragment DIGIT  : [0-9];
