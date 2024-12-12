package utils.bridge;

public abstract class Installer {
    protected InstallerImplementation implementation;

    public Installer(InstallerImplementation implementation) {
        this.implementation = implementation;
    }

    public abstract void createInstaller(String licenseKey, boolean createShortcut, String outputFormat);
}
