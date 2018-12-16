package com.hakurei.inter;

import com.hakurei.lexer.Token;
import com.hakurei.lexer.Word;
import com.hakurei.symbols.Type;

/**
 * @ClassName Unary
 * @Description TODO
 * @Author hakurei
 * @Date 2018/12/15
 * @Version 1.0
 */
public class Unary extends Expr {
    public Expr expr;
    public Unary(Token token, Expr x) {
        super(token,null);
        expr=x;

    }

    @Override
    public Expr gen() {
        return new Unary(op,expr.reduce());
    }

    @Override
    public String toString() {
        return  op.toString()+" "+expr.toString();
    }
}
