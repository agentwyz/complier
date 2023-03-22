package com.recomplier;

import java.io.CharArrayReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SimpleTokenLexer {
    public static void main(String[] args) {
        SimpleTokenLexer lexer = new SimpleTokenLexer();

        String script = "age>=2";
        System.out.println("parse: " + script);

        SimpleTokenReader tokenReader = lexer.tokenize(script);
        dump(tokenReader);
    }

    public static void dump(SimpleTokenReader tokenReader) {
        System.out.println("text\ttype");
        Token token = null;

        while ((token = tokenReader.read()) != null) {
            System.out.println(token.getText() + "\t\t" + token.getType());
        }
    }

    //创建三个临时变量
    private StringBuffer tokenText = null; //临时保存的文本
    private List<Token> tokens = null;     //保存解析出来的token
    private SimpleToken token = null;      //当前正在解析的token

    public DfaState initToken(char ch) {

        if (tokenText.length() > 0) {
            token.text = tokenText.toString();
            tokens.add(token);

            //重新赋值
            tokenText = new StringBuffer();
            token = new SimpleToken();
        }

        DfaState newState = DfaState.Initial;

        if (isDigit(ch)) {
            newState = DfaState.IntLiteral;
            token.tokenType = TokenType.Intliteral;
            tokenText.append(ch);
        } else if (isChar(ch)) {
            newState = DfaState.Id;
            token.tokenType = TokenType.Identifier;
            tokenText.append(ch);
        } else if (ch == '>') {
            newState = DfaState.GT;
            token.tokenType = TokenType.GT;
            tokenText.append(ch);
        }

        return newState;
    }

    public SimpleTokenReader tokenize(String code) {
        tokens = new ArrayList<Token>();

        CharArrayReader reader = new CharArrayReader(code.toCharArray());

        tokenText = new StringBuffer();
        token = new SimpleToken();

        int ich = 0;
        char ch = 0;

        DfaState state = DfaState.Initial;

        try {
            while ((ich = reader.read()) != -1) {
                ch = (char) ich;

                switch (state) {
                    case Initial:
                        state = initToken(ch);
                        break;
                    case Id:
                        if (isAlpha(ch) || isChar(ch)) {
                            tokenText.append(ch);
                        } else {
                            state = initToken(ch);
                        }
                        break;
                    case GT:
                        if (ch == '=') {
                            state = DfaState.GE;
                            token.tokenType = TokenType.GE;
                            tokenText.append(ch);
                        } else {
                            state = initToken(ch);
                        }
                        break;
                    case GE:
                        state = initToken(ch);
                        break;
                    case IntLiteral:
                        if (isDigit(ch)) {
                            tokenText.append(ch);
                        } else {
                            state = initToken(ch);
                        }
                        break;
                    default:
                }
            }
            if (tokenText.length() > 0) {
                initToken(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new SimpleTokenReader(tokens);
    }


    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private boolean isChar(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    private boolean isAlpha(char ch) {
        return ch == ' ' || ch == '\t' || ch == '\n';
    }

}


enum DfaState {
    Initial,
    Id,
    IntLiteral,
    GT,
    GE,
}


class SimpleToken implements Token {

    String text;
    TokenType tokenType;

    @Override
    public TokenType getType() {
        return this.tokenType;
    }

    @Override
    public String getText() {
        return text;
    }
}


class SimpleTokenReader implements TokenReader {
    List<Token> tokens = null;
    int pos = 0;

    public SimpleTokenReader(List<Token> tokens) {
        this.tokens = tokens;
    }

    @Override
    public Token read() {
        if (pos < tokens.size()) {
            return tokens.get(pos++);
        }
        else {
            return null;
        }
    }

    @Override
    public Token peek() {
        if (pos < tokens.size()) {
            return tokens.get(pos);
        }
        else {
            return null;
        }
    }

    @Override
    public void unread() {
        pos--;
    }

    @Override
    public int getPosition() {
        return pos;
    }

    @Override
    public void setPosition(int position) {
        if (position >= 0 && position < tokens.size()) {
            pos = position;
        }
    }
}