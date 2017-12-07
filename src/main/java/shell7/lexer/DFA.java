package shell7.lexer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DFA {

    private int[][] table = new int[26][50];
    private boolean[] accept = new boolean[50];
    private boolean[] back = new boolean[50];

    public DFA() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./resource/dfa.txt"));
        String line;
        int index = 0;
        while ((line = br.readLine()) != null) {
            String[] split = line.split("[ \t\n]+");
            for (int i = 0; i < split.length; i++) {
                if (split[i].equals("*")) // accept and go back
                    table[index][i] = -1;
                else if (split[i].equals("$")) // just accept
                    table[index][i] = -2;
                else if (split[i].equals("#")) // unreachable
                    table[index][i] = -3;
                else
                    table[index][i] = Integer.parseInt(split[i]);
            }
            index++;
        }

        for (int i = 0; i < accept.length; i++) {
            if (table[0][i] == -1) {
                accept[i] = true;
                back[i] = true;
            } else if (table[0][i] == -2) {
                accept[i] = true;
                back[i] = false;
            } else {
                accept[i] = false;
                back[i] = false;
            }
        }
    }

    public boolean isStop(int state) {
        return state == -3;
    }

    public boolean isAccept(int state) {
        return accept[state];
    }

    public boolean isBack(int state) {
        return back[state];
    }

    public int nextState(int state, char cond) throws Exception {
        int index;
        if (Character.isWhitespace(cond))
            index = 0;
        else if (Character.isDigit(cond))
            index = 1;
        else if (Character.isLetter(cond))
            index = 2;
        else {
            switch (cond) {
                case '.':index = 3;break;
                case 'E':index = 4;break;
                case 'e':index = 5;break;
                case '<':index = 6;break;
                case '>':index = 7;break;
                case '=':index = 8;break;
                case '!':index = 9;break;
                case '+':index = 10;break;
                case '-':index = 11;break;
                case '*':index = 12;break;
                case '/':index = 13;break;
                case '|':index = 14;break;
                case '&':index = 15;break;
                case '(':index = 16;break;
                case ')':index = 17;break;
                case '{':index = 18;break;
                case '}':index = 19;break;
                case '[':index = 20;break;
                case ']':index = 21;break;
                case ';':index = 22;break;
                case ',':index = 23;break;
                case '"':index = 24;break;
                default:index = 25;break;
            }
        }
        return table[index][state];
    }

    public String stateType(int state) throws Exception {
        switch (state) {
            case 2: return "WS";
            case 10: return "INTEGER";
            case 9: case 11: return "FLOAT";
            case 13: return "ID";
            case 18: case 20: case 21: case 23: case 25: case 26: return "COMPARISION";
            case 19: case 22: case 24: case 31: case 32: case 33: case 34: case 35: case 36: case 37: case 38: return "OPERATOR";
            case 39: case 40: case 41: case 42: case 43: case 44: case 45: case 46: return "SYMBOL";
            case 48: return "STRING";
            case 49: return "STOP";
            default: return "...";
        }
    }
}
