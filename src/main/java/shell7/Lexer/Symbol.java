package shell7.Lexer;

public class Symbol extends Token {

    private String value;

    public Symbol() {
        super("Symbol");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "value='" + value + '\'' +
                '}';
    }
}
