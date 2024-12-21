package utils.interpreter;

public class OutputFormatExpression implements Expression {
    private String format;

    public OutputFormatExpression(String format) {
        this.format = format;
    }

    @Override
    public boolean interpret(String context) {
        return context.contains("outputFormat=" + format);
    }
}