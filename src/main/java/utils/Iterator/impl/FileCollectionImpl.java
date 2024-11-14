package utils.Iterator.impl;

import models.File;
import utils.Iterator.FileCollection;
import utils.Iterator.Iterator;

import java.util.List;

public class FileCollectionImpl implements FileCollection {

    private List<File> files;

    public FileCollectionImpl(List<File> files) {
        this.files = files;
    }

    @Override
    public void add(File file) {
        files.add(file);
    }

    @Override
    public void remove(File file) {
        files.remove(file);
    }

    @Override
    public Iterator createIterator() {
        return new FileIteratorImpl(files);
    }
}
