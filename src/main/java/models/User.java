package models;

public class User {
    private int id;
    private String userName;
    private String license;
    private String email;
    private String password;

    // Конструктор
    public User(int id, String userName, String license, String email, String password) {
        this.id = id;
        this.userName = userName;
        this.license = license;
        this.email = email;
        this.password = password;
    }

    // Getters і Setters
    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getLicense() {
        return license;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
