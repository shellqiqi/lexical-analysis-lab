package shell7.Lexer;

public class Real extends Token {

    private double value;

    public Real() {
        super("Real");
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Real{" +
                "value=" + value +
                '}';
    }
}
