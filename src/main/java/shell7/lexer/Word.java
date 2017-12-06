package shell7.lexer;

public class Word extends Token {

    private final String value;

    public Word(String tag, String value) {
        super(tag);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Word{" +
                "value='" + value + '\'' +
                '}';
    }
}
