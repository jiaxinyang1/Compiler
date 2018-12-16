package com.hakurei.symbols;

import com.hakurei.lexer.Token;

import java.util.Hashtable;

/**
 * @ClassName Env
 * @Description TODO
 * @Author hakurei
 * @Date 2018/12/15
 * @Version 1.0
 */
public class Env {
    private Hashtable table;
    protected Env prev;
    public  Env(Env n){
        table =new Hashtable();
        prev=n;
    }
    public  void put(Token w ,Id i){
        table.put(w,i);
    }
    public  Id get(Token w){
        for (Env e =this;e!=null;e=e.prev){
            Id found =(Id) (e.table.get(w));
            if (found!=null){
                return  found;
            }

        }
        return null;
    }
}
