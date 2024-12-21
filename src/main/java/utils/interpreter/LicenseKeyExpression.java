package utils.interpreter;

public class LicenseKeyExpression implements Expression {
    private String licenseKey;

    public LicenseKeyExpression(String licenseKey) {
        this.licenseKey = licenseKey;
    }

    @Override
    public boolean interpret(String context) {
        return context.contains("licenseKey=" + licenseKey);
    }
}
