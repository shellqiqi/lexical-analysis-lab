package shell7.lexer;

import java.io.IOException;
import java.util.Hashtable;

public class Lexer {

    private static int line = 1;
    private char peek = ' ';

    private DFA dfa = new DFA();
    private Hashtable words = new Hashtable();

    public Lexer() throws IOException {
        reserve(new Word("MAIN", "main"));
        reserve(new Word("IF", "if"));
        reserve(new Word("ELSE", "else"));
        reserve(new Word("FOR", "for"));
        reserve(new Word("TYPE", "void"));
        reserve(new Word("TYPE", "char"));
        reserve(new Word("TYPE", "int"));
        reserve(new Word("MODIFIER", "signed"));
        reserve(new Word("MODIFIER", "unsigned"));
        reserve(new Word("RETURN", "return"));
    }

    public void reserve(Word w) {
        words.put(w.getValue(), w);
    }

    // TODO: make it read file
    public void readch() throws IOException {
        peek = (char)System.in.read();
    }

    public boolean readch(char c) throws IOException {
        readch();
        if (peek != c) return false;
        peek = ' ';
        return true;
    }

    // TODO: complete this
    public Token scan() throws Exception {
        int state = 0;
        boolean lookBack = false;
        StringBuffer buffer = new StringBuffer();
        while (true) {
            readch();
            int nextState =  dfa.nextState(0, peek);
            if (nextState == -1)
                return new Word(dfa.stateType(state), buffer.toString());
            else if (nextState == -2)
                ;
            else if (nextState == -3)
                ;
        }
    }
}
