import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        List<File> folderList = Arrays.asList(
                new File("C://Games"),
                new File("C://Games//temp"),
                new File("C://Games//src"),
                new File("C://Games//res"),
                new File("C://Games//savegames"),
                new File("C://Games//src//main"),
                new File("C://Games//src//test"),
                new File("C://Games//res//drawables"),
                new File("C://Games//res//vectors"),
                new File("C://Games//res//icons")
        );
        List<File> fileList = Arrays.asList(
                new File("C://Games//main//Main.java"),
                new File("C://Games//main//Utils.java")
        );
        folderList.stream().forEach(folder -> {
            if (folder.mkdir()) sb.append("Каталог " + folder + " создан");
            else sb.append("Каталог " + folder + " не создан");
        });
        fileList.stream().forEach(file -> {
                    try {
                        if (file.createNewFile()) sb.append("Файл " + file + " создан");
                        else sb.append("Файл " + file + "не создан");
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
        );
        try (FileWriter writer = new FileWriter("C://Games//temp//temp.txt", false)) {
            String text = "Hello Gold!";
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}