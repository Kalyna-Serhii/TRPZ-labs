package utils.interpreter;

public class ShortcutExpression implements Expression {
    @Override
    public boolean interpret(String context) {
        return context.contains("addShortcut=true");
    }
}