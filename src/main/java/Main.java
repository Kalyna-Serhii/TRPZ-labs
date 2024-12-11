import utils.bridge.*;

public class Main {
    public static void main(String[] args) {
        InstallerImplementation windowsImpl = new WindowsInstaller();
        Installer windowsInstaller = new CustomInstaller(windowsImpl);
        windowsInstaller.createInstaller("1234-5678-91011", true, "exe");

        System.out.println();

        InstallerImplementation macImpl = new MacInstaller();
        Installer macInstaller = new CustomInstaller(macImpl);
        macInstaller.createInstaller("ABCD-EFGH-IJKL", false, "msi");
    }
}
