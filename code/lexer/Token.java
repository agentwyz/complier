package com.recomplier;

public interface Token {
    //设置两个方法
    public TokenType getType();

    //token字面量
    public String getText();
}
