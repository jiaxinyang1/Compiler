package com.hakurei.lexer;

/**
 * @ClassName Token
 * @Description TODO
 * @Author hakurei
 * @Date 2018/12/2
 * @Version 1.0
 */
public class Token {
    public final int tag;
    public Token(int t){
        tag=t;
    }
    @Override
    public String toString(){
        return ""+(char)tag;
    }
}
