package com.hakurei.symbols;

import com.hakurei.lexer.Tag;
import com.hakurei.lexer.Word;

/**
 * @ClassName Type
 * @Description TODO
 * @Author hakurei
 * @Date 2018/12/15
 * @Version 1.0
 */
public class Type extends Word {


    public  int width= 0;
    public Type(String s,int tag, int w){
        super(s,tag);
        width=w;
    }
    public  static final  Type
        var =new Type("var", Tag.BASIC,1),
        Int  = new Type("int",Tag.BASIC,4),
        Float =new Type("float",Tag.BASIC,8);

}
