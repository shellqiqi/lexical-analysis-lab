package shell7.Lexer;

public class Str extends Token {

    private String value;

    public Str() {
        super("String");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = "\"" + value + "\"";
    }

    @Override
    public String toString() {
        return "Str{" +
                "value='" + value + '\'' +
                '}';
    }
}
