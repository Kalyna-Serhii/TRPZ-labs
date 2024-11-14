import models.File;
import utils.Iterator.FileCollection;
import utils.Iterator.Iterator;
import utils.Iterator.impl.FileCollectionImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        File file1 = new File(1, "document1.txt", 1024, "/user/documents/document1.txt");
        File file2 = new File(2, "image1.jpg", 2048, "/user/images/image1.jpg");
        File file3 = new File(3, "presentation.pptx", 4096, "/user/presentations/presentation.pptx");
        File file4 = new File(4, "video.mp4", 8192, "/user/videos/video.mp4");
        File file5 = new File(5, "music.mp3", 5120, "/user/music/music.mp3");

        List<File> filesList = new ArrayList<>();

        filesList.add(file1);
        filesList.add(file2);
        filesList.add(file3);
        filesList.add(file4);
        filesList.add(file5);

        FileCollection fileCollection = new FileCollectionImpl(filesList);

        Iterator fileIterator = fileCollection.createIterator();

        while(fileIterator.hasNext()){
            System.out.println(fileIterator.next());
        }

    }
}
