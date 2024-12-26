import utils.interpreter.*;

public class Main {
    public static void main(String[] args) {
        String userInput = "addShortcut=true licenseKey=ABC123 outputFormat=.exe";

        Expression addShortcut = new ShortcutExpression();
        Expression licenseKey = new LicenseKeyExpression("ABC123");
        Expression outputFormatExe = new OutputFormatExpression(".exe");

        Expression fullInstallSetup = new AndExpression(
                new AndExpression(addShortcut, licenseKey),
                outputFormatExe
        );

        Expression outputFormatMsi = new OutputFormatExpression(".msi");
        Expression flexibleOutputFormat = new OrExpression(outputFormatExe, outputFormatMsi);

        System.out.println("Shortcut: " + fullInstallSetup.interpret(userInput));
        System.out.println("Any format: " + flexibleOutputFormat.interpret(userInput));
    }
}
