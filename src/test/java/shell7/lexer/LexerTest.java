package shell7.lexer;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import static org.junit.Assert.*;

public class LexerTest {

    private Lexer lexer;

    @Before
    public void constructor() throws Exception {
        lexer = new Lexer(new BufferedReader(new FileReader("./resource/test.txt")));
    }
}