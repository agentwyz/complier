grammar play;

import CommonLexer; //导入词法定义

/*下面的内容加到所 */
@header {
    package antlr;
}

literal
    : IntegerLiteral
    | FloatingPointLiteral
    | BooleanLiteral
    | CharacterLiteral
    | StringLiteral
    | NullLiteral
    ;

primitiveType
    : 'Number'
    | 'String'
    | 'Var'
    ;

statement
    : expressionStatement
    | compoundStatement
    ;

expressionStatement
    : expression? ';'
    ;

declaration
    : primitiveType Identifier
    | primitiveType Identifier initializer
    ;

initializer
    : assignmentOperator assignmentExpression
    ;

expression
    : assignmentExpression
    | expression ',' assignmentExpression
    ;

assignmentExpression
    : additiveExpression
    | Identifier assignmentOperator additiveExpression
    ;

assignmentOperator
    : '='
    | '*='
    | '/='
    | '%='
    | '+='
    | '-='
    | '<<='
    | '>>='
    | '>>>='
    | '&='
    | '^='
    | '|='
    ;

additiveExpression
    : multiplicativeExpression
    | additiveExpression '+' multiplicativeExpression
    | additiveExpression '-' multiplicativeExpression
    ;

multiplicativeExpression
    : primaryExpression
    | multiplicativeExpression '*' primaryExpression
    | multiplicativeExpression '/' primaryExpression
    | multiplicativeExpression '%' primaryExpression
    ;

primaryExpression
    : Identifier
    | literal
    | Identifier '(' argumentExpressionList? ')'
    | '(' expression ')'
    ;

argumentExpressionList
    : assignmentExpression
    | argumentExpressionList ',' assignmentExpression
    ;

compoundStatement
    : '{' blockItemList? '}'
    ;

blockItemList
    : blockItem
    | blockItemList blockItem
    ;

blockItem
    : statement
    | declaration
    ;