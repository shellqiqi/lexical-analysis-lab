package shell7.lexer;

public class Token {

    private final String tag;
    private final String value;

    public Token(String tag, String value) {
        this.tag = tag;
        this.value = value;
    }

    public String getTag() {
        return tag;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getTag() + ":\'" + getValue() + "\'";
    }
}
