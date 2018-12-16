package com.hakurei.parser;

import com.hakurei.inter.*;
import com.hakurei.lexer.*;
import com.hakurei.symbols.Env;
import com.hakurei.symbols.Type;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * @ClassName Parser
 * @Description TODO
 * @Author hakurei
 * @Date 2018/12/15
 * @Version 1.0
 */
public class Parser {
    private Lexer lex;
    private Token look;

    private List all= new ArrayList();
    private static Hashtable<String,Object>  var =new Hashtable();
    private  double result;
    Env top = null;
    int used=0;
    public  Parser(Lexer l )  {
        lex=l;

    }
    void move()throws  IOException {

        look =lex.scan();

    }
    void error(String  s ){
        throw  new Error("near line"+Lexer.line+":"+s);
    }
    boolean match(int t)throws  IOException {
        if (look.tag==t) {
            move();
            return true;
        }
        else {
            return false;

        }


    }
    public void program()throws IOException{
        move();
        Expr x=null;
        if (look.tag=='$'){
            return;
        }
        if (look.tag==Tag.ID){
            move();
            if (look.tag=='='){
                x=assign();
            }
            else {
                lex.back();
                lex.back();
                move();
                x = stmt();

            }

        }
        else {
            x = stmt();
        }

        System.out.println(x);




    }
    Expr assign() throws IOException{
        lex.back();
        lex.back();
        move();
        Token t=look;
        match(Tag.ID);
        Expr res=null;
        Object v  =var.get(t);
        if (v==null){
                match('=');
                res =bool();
                var.put(t.toString(),res);



        }
        else {
                match('=');
                res =bool();
                var.remove(t);
                var.put(t.toString(),res);


        }
        return  res;
    }


    private Expr stmt() throws IOException {


        Expr x =bool();

        return x;

    }

    Expr factor() throws IOException{
        Expr x =null;

        switch (look.tag){

            case '(':
                move();x=bool();
                match(')');
                return x;
            case Tag.NUM:
                x= new Constant(look,Type.Int);
                move();
                return  x;
            case Tag.REAL:
                x= new Constant(look,Type.Float);

                move();
                return  x;
            case Tag.ID:

                    String s =look.toString();
                    double res= Double.parseDouble(var.get(s).toString());
                    x=new Constant(new Real((float)(res)),Type.Float);
                    move();




                return  x;
            default:
                error("syntax error");
                return x;

        }
    }

    private Expr bool() throws IOException {
        Expr x =expr();


        return  x;
    }

    private Expr expr() throws IOException {

        Expr x =term();

        while (look.tag=='+'||look.tag=='-'||look.tag=='='){


            Token tok =look;move();x= new Arith(tok,x,term());
            double x1 = Double.parseDouble(((Arith) x).expr1.toString().replace(" ",""));
            double x2=Double.parseDouble(((Arith) x).expr2.toString().replace(" ",""));
            if (tok.tag=='+'){

                x= new Constant(new Real((float)(x1+x2)),Type.Float);


            }
            else {
                x= new Constant(new Real((float)(x1-x2)),Type.Float);
            }

        }
        return x;
    }

    private Expr term() throws IOException {
        Expr x =unary();
        while (look.tag=='*'||look.tag=='/'){

            Token tok =look;move();x= new Arith(tok,x,unary());

            double x1 = Double.parseDouble(((Arith) x).expr1.toString().replace(" ",""));
            double x2=Double.parseDouble(((Arith) x).expr2.toString().replace(" ",""));

            if (tok.tag=='*'){

                 x= new Constant(new Real((float)(x1*x2)),Type.Float);


            }
            else {
                 x= new Constant(new Real((float)(x1/x2)),Type.Float);
            }
            System.out.println(x.toString());

        }

        return  x;
    }

    private Expr unary() throws IOException {
        if(look.tag =='-'){
            move();
            return  new Unary(Word.minus,unary());
        }

        else {
            return factor();
        }
    }


}
