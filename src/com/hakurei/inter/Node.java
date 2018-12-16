package com.hakurei.inter;

import com.hakurei.lexer.Lexer;

/**
 * @ClassName Node
 * @Description TODO
 * @Author hakurei
 * @Date 2018/12/15
 * @Version 1.0
 */
public class Node {
    int lexline= 0;
    Node(){
        lexline =Lexer.line;
    }
    void error(String s){
        throw new Error("near line"+lexline+":" +s);

    }
    static  int labels=0;
    public  int newlabel(){
        return ++labels;
    }
    public  void emitlabel(int i){
        System.out.println("L" +i+":");
    }
    public void emit(String s){
        System.out.println("\t"+s);
    }

}
