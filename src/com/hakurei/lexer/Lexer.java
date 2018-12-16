package com.hakurei.lexer;


import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName Lexer
 * @Description TODO
 * @Author hakurei
 * @Date 2018/12/2
 * @Version 1.0
 */
public class Lexer {

    public static int line =1;
    char peek=' ';
    HashMap words =new HashMap();
    void reserve(Word w){
        words.put(w.lexeme,w);
    }
    String expr="";

    int index= 0;
    public Lexer(){

    }
    public void  read(){

        Scanner sc=new Scanner(System.in);
        expr= sc.nextLine();
        expr=expr+'$';
    }

    void readch()throws IOException {
        if (index<expr.length()){

            peek =expr.charAt(index);
            if (peek=='$'){
                index=-1;
            }
            index++;
        }


    }
    public void back(){
        index--;
    }
    boolean readch(char c)throws  IOException{
        readch();
        if (peek!=c){
            return false;
        }
        peek=' ';
        return  true;
    }

    public Token scan() throws IOException{
        for (;;readch()){
            if (peek==' '||peek=='\t'){
                continue;
            }
            else  if(peek =='\n'){
                break;
            }
            else {
                break;
            }
        }

        if (Character.isDigit(peek)) {
            int v=0;
            do{
                v=10*v +Character.digit(peek,10);readch();
            }while (Character.isDigit(peek));
            if (peek!='.') {
                return new Num(v);
            }
            float x=v; float d=10;
            for (;;){
                readch();
                if(!Character.isDigit(peek)){
                    break;
                }
                x=x+Character.digit(peek,10)/d;d=d*10;
            }

            return  new Real(x);

        }
        if (Character.isLetter(peek)){
            StringBuffer b= new StringBuffer();
            do {
                b.append(peek); readch();
            }while (Character.isLetterOrDigit(peek));
            String s =b.toString();
            Word w =(Word)words.get(s);
            if (w!=null){
                return  w;
            }
            w= new Word(s,Tag.ID);
            words.put(s,w);
            return w;
        }

        Token tok = new Token(peek); peek=' ';

        return tok;

    }
}
