package shell7.lexer;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Hashtable;

public class Lexer {

    private char peek;

    private DFA dfa ;
    private Hashtable<String, Word> words;

    private BufferedReader bufferedReader;

    public Lexer(BufferedReader reader) throws Exception {
        init();
        bufferedReader = reader;
    }

    private void init() throws Exception {
        peek = ' ';
        dfa = new DFA();
        words = new Hashtable<String, Word>();
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

    public void readNextChar() throws IOException {
        peek = (char)bufferedReader.read();
    }

    public Token getNextToken() throws Exception {
        int state = 0;
        int next;
        StringBuffer buffer = new StringBuffer();

        while (true) {
            next = dfa.nextState(state, peek);
            String stateName = dfa.stateType(next);

            if (dfa.isStop(next)) {
                return null;
            }

            if (dfa.isAccept(next)) { // Accept state
                if (dfa.isBack(next)) { // State with *
                    if (words.containsKey(buffer.toString())) // Check keywords
                        return words.get(buffer.toString());
                    if (stateName.equals("WS")) { // Ignore whitespace
                        state = 0;
                        buffer = new StringBuffer();
                        continue;
                    }
                    return new Word(stateName, buffer.toString());
                } else {
                    buffer.append(peek);
                    readNextChar();
                    return new Word(stateName, buffer.toString());
                }
            }
            state = next;

            buffer.append(peek);
            readNextChar();
        }
    }
}
