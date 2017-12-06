package shell7.Lexer;

public class ID extends Token {

    private String value;

    public ID() {
        super("ID");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ID{" +
                "value='" + value + '\'' +
                '}';
    }
}
