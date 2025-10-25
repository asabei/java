package Lesson7HW;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.List;

public class LogerService {
    private static final Path path = Path.of("src/main/java/Lesson7HW/file.txt");
    public static void writeLog(String infoMessage, String sendObject){

        try {
            String newStr = String.format("%s: %s: %s%n", LocalDateTime.now(), infoMessage, sendObject);
            OutputStream out = Files.newOutputStream(path,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
            out.write(newStr.getBytes());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> readLog(){
        try{
            List<String> in = Files.readAllLines(path);
            return in;
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}


