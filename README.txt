SimpleLexer: 定义一个lexer类
TokenReader: 一个接口, 用于实现读取token的流
TokenType: 一个枚举, 用于定义tokentype
Dfastate: 定义各种状态

核心的三个变量:
1. token: 当前正在解析的token
2. tokenText: 用于保存临时的token文本
3.  tokens: 用于存储解析出来的token, 用stringBuffer进行定义

 