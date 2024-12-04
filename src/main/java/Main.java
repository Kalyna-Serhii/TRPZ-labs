import models.File;
import utils.factory.ConcreteFileFactory;
import utils.factory.FileFactory;

public class Main {

        public static void main(String[] args) {
            File file1 = new File.FileBuilder()
                    .setId(1)
                    .setFileName("document1.txt")
                    .setSize(1024L)
                    .setPath("/user/documents/document1.txt")
                    .build();

            FileFactory fileFactory = new ConcreteFileFactory(file1.getId(), file1.getFileName(), file1.getSize(), file1.getPath());

            File file = fileFactory.createFile();

            System.out.println("Інформація про файл:");
            System.out.println("ID: " + file.getId());
            System.out.println("Назва файлу: " + file.getFileName());
            System.out.println("Розмір: " + file.getSize() + " байт");
            System.out.println("Шлях: " + file.getPath());

            System.out.println("\nРезультат методу display():");
            file.display();
        }
}
