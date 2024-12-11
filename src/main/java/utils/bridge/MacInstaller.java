package utils.bridge;

public class MacInstaller implements InstallerImplementation {
    @Override
    public void setupFiles() {
        System.out.println("Setting up files for Mac installation...");
    }

    @Override
    public void configureSettings(String licenseKey, boolean createShortcut) {
        System.out.println("Configuring settings for Mac:");
        System.out.println("License Key: " + licenseKey);
        System.out.println("Create Shortcut: " + (createShortcut ? "Yes" : "No"));
    }

    @Override
    public void generateInstaller(String outputFormat) {
        System.out.println("Generating Mac installer as ." + outputFormat);
    }
}