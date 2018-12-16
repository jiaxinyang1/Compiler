package com.hakurei.lexer;

/**
 * @ClassName Num
 * @Description TODO
 * @Author hakurei
 * @Date 2018/12/2
 * @Version 1.0
 */
public class Num extends Token {
    public final int value;
    public Num(int v){
        super(Tag.NUM);
        value=v;
    }
    @Override
    public String  toString(){
        return  ""+value;
    }

}
