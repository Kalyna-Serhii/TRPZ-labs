package models;

public class File {
    private int id;
    private String fileName;
    private long size;
    private String path;

    // Конструктор
    public File(int id, String fileName, long size, String path) {
        this.id = id;
        this.fileName = fileName;
        this.size = size;
        this.path = path;
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
}
