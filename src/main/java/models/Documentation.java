package models;

public class Documentation {
    private int id;
    private User user_id;
    private String license;
    private String info;

    // Конструктор
    public Documentation(int id, User user_id, String license, String info) {
        this.id = id;
        this.user_id = user_id;
        this.license = license;
        this.info = info;
    }

    // Getters і Setters
    public int getId() {
        return id;
    }

    public User getUser_id() { return user_id; }

    public String getLicense() {
        return license;
    }

    public String getInfo() {
        return info;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_id(User user_id) { this.user_id = user_id; }

    public void setLicense(String license) {
        this.license = license;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
