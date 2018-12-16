package com.hakurei.inter;

import com.hakurei.lexer.Num;
import com.hakurei.lexer.Token;
import com.hakurei.symbols.Type;

/**
 * @ClassName Constant
 * @Description TODO
 * @Author hakurei
 * @Date 2018/12/15
 * @Version 1.0
 */
public class Constant extends Expr {

    public  Constant(int i){
        super(new Num(i),Type.Int);
    }
    public Constant(Token tok, Type p) {
        super(tok, p);
    }

}
