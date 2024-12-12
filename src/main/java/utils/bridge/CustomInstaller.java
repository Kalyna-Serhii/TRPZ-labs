package utils.bridge;

public class CustomInstaller extends Installer {

    public CustomInstaller(InstallerImplementation implementation) {
        super(implementation);
    }

    @Override
    public void createInstaller(String licenseKey, boolean createShortcut, String outputFormat) {
        implementation.setupFiles();
        implementation.configureSettings(licenseKey, createShortcut);
        implementation.generateInstaller(outputFormat);
    }
}
