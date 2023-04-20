## lexer

SimpleLexer: 定义一个lexer类
TokenReader: 一个接口, 用于实现读取token的流
TokenType: 一个枚举, 用于定义tokentype
Dfastate: 定义各种状态

核心的三个变量:
1. token: 当前正在解析的token
2. tokenText: 用于保存临时的token文本
3. tokens: 用于存储解析出来的token, 用stringBuffer进行定义

目前lexer已经实现变量的定义和初始化的解析


## Parser, calculator

intDeclare: parse变量声明

关键的地方在于消除左递归

注意这样写就不会产生左递归
additive :
          multiplicative
        | multiplicative Plus additive 

but:
additive :
          multiplicative
        | additive Plus multiplicative

--------------------------------------------------------
确保正确的结合性

上面我们消除了左边递归, 但是出现了一点问题, 那就是结合性出现了一点问题

下面我们就来看一看如何消除左递归, 消除左递归, 使用一个标准的方法, 就能够把左递归文法改写成非左递归的文法
以加法表达式规则为例, 原来的文法是`add->add + mul` 现在我们改写成:

```bnf
add -> mul add'
add' -> + mul add' | ε

mul -> pri
```


我们使用2+3+4这个表达式去匹配上面的东西

首先2是mul, 消耗掉, 然后进入匹配add', 发现有+， 于是消耗掉, 然后继续匹配 是不是mul, 发现有3 于是消耗掉, 于是检查下一个位置发现是+, 于是消耗掉
于是继续执行上面的步骤。



