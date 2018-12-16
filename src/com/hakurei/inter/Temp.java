package com.hakurei.inter;

import com.hakurei.lexer.Token;
import com.hakurei.lexer.Word;
import com.hakurei.symbols.Type;

/**
 * @ClassName Temp
 * @Description TODO
 * @Author hakurei
 * @Date 2018/12/15
 * @Version 1.0
 */
public class Temp  extends  Expr{

   static  int count =0;
   int number =0;

    public Temp(Type p) {

        super(Word.temp,p);
        number=++count;
    }

    @Override
    public String toString() {
        return "t"+number;
    }
}
