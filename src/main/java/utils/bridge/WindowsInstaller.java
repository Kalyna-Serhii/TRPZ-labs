package utils.bridge;

public class WindowsInstaller implements InstallerImplementation {
    @Override
    public void setupFiles() {
        System.out.println("Setting up files for Windows installation...");
    }

    @Override
    public void configureSettings(String licenseKey, boolean createShortcut) {
        System.out.println("Configuring settings for Windows:");
        System.out.println("License Key: " + licenseKey);
        System.out.println("Create Shortcut: " + (createShortcut ? "Yes" : "No"));
    }

    @Override
    public void generateInstaller(String outputFormat) {
        System.out.println("Generating Windows installer as ." + outputFormat);
    }
}
