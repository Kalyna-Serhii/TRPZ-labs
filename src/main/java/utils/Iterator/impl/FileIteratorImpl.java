package utils.Iterator.impl;

import models.File;
import utils.Iterator.Iterator;

import java.util.List;
import java.util.NoSuchElementException;

public class FileIteratorImpl implements Iterator {

    private int currentPos = 0;
    private final List<File> fileList;

    public FileIteratorImpl(List<File> fileList) {
        this.fileList = fileList;
    }

    @Override
    public boolean hasNext() {
        return currentPos < fileList.size();
    }

    @Override
    public File next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return  fileList.get(currentPos++);
    }
}
