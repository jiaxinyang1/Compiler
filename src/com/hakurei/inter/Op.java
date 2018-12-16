package com.hakurei.inter;

import com.hakurei.lexer.Token;
import com.hakurei.symbols.Type;

/**
 * @ClassName Op
 * @Description TODO
 * @Author hakurei
 * @Date 2018/12/15
 * @Version 1.0
 */
public class Op extends Expr {
    public Op(Token tok, Type p){
        super(tok,p);
    }
    @Override
    public  Expr reduce(){
        Expr x= gen();
        Temp t  =new Temp(type);
        emit(t.toString()+" = "+x.toString());
        return  t;
    }
}
