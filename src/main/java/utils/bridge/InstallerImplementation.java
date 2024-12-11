package utils.bridge;

public interface InstallerImplementation {
    void setupFiles();

    void configureSettings(String licenseKey, boolean createShortcut);

    void generateInstaller(String outputFormat);
}