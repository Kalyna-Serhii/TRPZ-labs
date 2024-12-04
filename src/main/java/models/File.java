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

    public File(FileBuilder builder) {
        this.fileName = builder.fileName;
        this.size = builder.size;
        this.path = builder.path;
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

    @Override
    public String toString(){
        return "FileName id: " + id + " size: " + size + " fileName: " + fileName + " path: " + path;
    }

    public static class FileBuilder {
        private String fileName;
        private long size;
        private String path;

        public FileBuilder setFileName(String fileName) {
            this.fileName = fileName;
            return this;
        }
        public FileBuilder setSize(long size) {
            this.size = size;
            return this;
        }
        public FileBuilder setPath(String path) {
            this.path = path;
            return this;
        }

        public File build() {
            return new File(this);
        }
    }
}
