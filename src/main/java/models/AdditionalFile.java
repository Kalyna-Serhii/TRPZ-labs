package models;

public class AdditionalFile {
    private int id;
    private String fileName;
    private long size;
    private String path;
    private String protectionParams;

    // Конструктор
    public AdditionalFile(int id, String fileName, long size, String path, String protectionParams) {
        this.id = id;
        this.fileName = fileName;
        this.size = size;
        this.path = path;
        this.protectionParams = protectionParams;
    }

    // Getters і Setters
    public int getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public long getSize() {
        return size;
    }

    public String getPath() {
        return path;
    }

    public String getProtectionParams() {
        return protectionParams;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setProtectionParams(String protectionParams) {
        this.protectionParams = protectionParams;
    }
}
