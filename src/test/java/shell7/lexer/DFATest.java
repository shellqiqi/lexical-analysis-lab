package shell7.lexer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

public class DFATest {

    private DFA dfa;

    @Before
    public void testConstructor() throws IOException {
        dfa = new DFA();
    }

    @Test
    public void testDFA() throws Exception {
        assertEquals(dfa.nextState(0, ' '), 1);
        assertEquals(dfa.nextState(0, '7'), 3);
        assertEquals(dfa.nextState(0, 'k'), 12);
        assertEquals(dfa.nextState(16, '='), 25);
        assertEquals(dfa.nextState(19, '4'), -2);
        assertEquals(dfa.nextState(7, '3'), 8);
        assertEquals(dfa.nextState(30, ','), -3);
        assertEquals(dfa.nextState(33, 'd'), -1);
    }
}