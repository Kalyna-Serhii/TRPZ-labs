import models.File;

public class Main {

    public static void main(String[] args) {
        File file1 = new File.FileBuilder()
                .setFileName("document1.txt")
                .setSize(1024L)
                .setPath("/user/documents/document1.txt")
                .build();

        File file2 = new File.FileBuilder()
                .setFileName("image1.jpg")
                .setSize(2048L)
                .setPath("/user/images/image1.jpg")
                .build();

        File file3 = new File.FileBuilder()
                .setFileName("presentation.pptx")
                .setSize(4096L)
                .setPath("/user/presentations/presentation.pptx")
                .build();

        File file4 = new File.FileBuilder()
                .setFileName("video.mp4")
                .setSize(8192L)
                .setPath("/user/videos/video.mp4")
                .build();

        File file5 = new File.FileBuilder()
                .setFileName("music.mp3")
                .setSize(5120L)
                .setPath("/user/music/music.mp3")
                .build();

        System.out.println(file1);
        System.out.println(file2);
        System.out.println(file3);
        System.out.println(file4);
        System.out.println(file5);
    }
}
