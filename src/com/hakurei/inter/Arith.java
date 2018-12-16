package com.hakurei.inter;

import com.hakurei.lexer.Token;
import com.hakurei.symbols.Type;

/**
 * @ClassName Arith
 * @Description TODO
 * @Author hakurei
 * @Date 2018/12/15
 * @Version 1.0
 */
public class Arith extends Op {
    public  Expr expr1,expr2;
    public Arith(Token tok, Expr x1,Expr x2) {
        super(tok, null);
        expr1=x1;
        expr2=x2;

    }
    @Override
    public  Expr gen(){
        return  new Arith(op,expr1.reduce(),expr2.reduce());
    }

    @Override
    public String toString() {
        return expr1.toString()+" "+op.toString()+" "+expr2.toString();
    }
}
