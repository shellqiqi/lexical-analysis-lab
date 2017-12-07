package shell7;

import shell7.lexer.Lexer;
import shell7.lexer.Token;

import java.io.BufferedReader;
import java.io.FileReader;

public class App {
    public static void main(String[] args) {
        try {
            Lexer lexer = new Lexer(new BufferedReader(new FileReader("./resource/test.txt")));
            Token t;
            while ((t = lexer.getNextToken()) != null) {
                System.out.println(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
