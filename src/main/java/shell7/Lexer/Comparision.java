package shell7.Lexer;

public class Comparision extends Token {

    private String value;

    public Comparision() {
        super("Comparision");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Comparision{" +
                "value='" + value + '\'' +
                '}';
    }
}
