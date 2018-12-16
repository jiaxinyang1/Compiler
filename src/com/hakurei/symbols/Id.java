package com.hakurei.symbols;

import com.hakurei.inter.Expr;
import com.hakurei.lexer.Token;
import com.hakurei.lexer.Word;

/**
 * @ClassName Id
 * @Description TODO
 * @Author hakurei
 * @Date 2018/12/15
 * @Version 1.0
 */
public class Id extends Expr {
    public int offset;
    public Id(Word id, Type p,int b) {
        super(id, p);
        offset=b;
    }
}
