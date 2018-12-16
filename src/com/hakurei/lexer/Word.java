package com.hakurei.lexer;

/**
 * @ClassName Word
 * @Description TODO
 * @Author hakurei
 * @Date 2018/12/2
 * @Version 1.0
 */
public class Word extends Token {

    public String lexeme;
    public Word(String s,int tag){
        super(tag);
        lexeme=s;
    }
    @Override
    public String toString(){
        return  lexeme;
    }
    public static final  Word and =new Word("&&",Tag.AND),
     temp =new Word("t",Tag.TEMP),minus =new Word("-",Tag.MINUS);

}
