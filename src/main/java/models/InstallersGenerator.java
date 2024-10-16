package models;

public class InstallersGenerator {

    private int id;
    private File file;
    private User user;
    private InstallationOptions installationOptions;
    private boolean shortcut;

    // Конструктор
    public InstallersGenerator(int id, File file, User user, InstallationOptions installationOptions, boolean shortcut) {
        this.id = id;
        this.file = file;
        this.user = user;
        this.installationOptions = installationOptions;
        this.shortcut = shortcut;
    }

    // Getters і Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public InstallationOptions getInstallationOptions() {
        return installationOptions;
    }

    public void setInstallationOptions(InstallationOptions installationOptions) {
        this.installationOptions = installationOptions;
    }

    public boolean isShortcut() {
        return shortcut;
    }

    public void setShortcut(boolean shortcut) {
        this.shortcut = shortcut;
    }
}
