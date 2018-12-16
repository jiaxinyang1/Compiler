package com.hakurei;

import com.hakurei.lexer.Lexer;
import com.hakurei.parser.Parser;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Lexer lex =new Lexer();
        Parser parser = new Parser(lex);


        while (true){
            lex.read();
            parser.program();


        }




    }
}
