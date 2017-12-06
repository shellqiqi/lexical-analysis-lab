package shell7.Lexer;

public class Token {

    private final String tag;

    public Token(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    @Override
    public String toString() {
        return "Token{" +
                "tag='" + tag + '\'' +
                '}';
    }
}