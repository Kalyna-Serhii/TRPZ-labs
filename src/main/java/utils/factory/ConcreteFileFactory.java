package utils.factory;
import models.File;

public class ConcreteFileFactory extends FileFactory {
    private int id;
    private String fileName;
    private long size;
    private String path;

    public ConcreteFileFactory(int id, String fileName, long size, String path) {
        this.id = id;
        this.fileName = fileName;
        this.size = size;
        this.path = path;
    }

    @Override
    public File createFile() {
        return new File(id, fileName, size, path);
    }
}