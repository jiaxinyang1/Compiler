package com.hakurei.lexer;

/**
 * @ClassName Real
 * @Description TODO
 * @Author hakurei
 * @Date 2018/12/2
 * @Version 1.0
 */
public class Real extends Token {

    public final   float value;
    public Real(float v){
        super(Tag.REAL);
        value=v;
    }
    @Override
    public String  toString(){
        return  ""+value;
    }
}
