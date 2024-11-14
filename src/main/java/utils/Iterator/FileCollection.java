package utils.Iterator;

import models.File;

public interface FileCollection {
    public void add(File file);
    public void remove(File file);
    public Iterator createIterator();
}
