package shell7.Lexer;

public class Number extends Token {

    private int value;

    public Number() {
        super("Number");
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Number{" +
                "value=" + value +
                '}';
    }
}
