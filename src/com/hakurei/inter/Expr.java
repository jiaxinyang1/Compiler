package com.hakurei.inter;

import com.hakurei.lexer.Token;
import com.hakurei.symbols.Type;

/**
 * @ClassName Expr
 * @Description TODO
 * @Author hakurei
 * @Date 2018/12/15
 * @Version 1.0
 */
public class Expr extends Node {
    public Token op;
    public Type type;
    public Expr(Token tok, Type p){
        op=tok;
        type=p;
    }
    public  Expr gen(){
        return  this;
    }
    public  Expr reduce(){
        return this;
    }

    @Override
    public String toString() {
        return op.toString();
    }
}
