package HWFINAL.SERVICE;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class Logging {
    private static final Path LOG_FILE = Path.of("src/main/java/HWFINAL/database.log");
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void writeLog(String sendObject){
        try {
            String newStr = String.format("%s: %s%n", LocalDateTime.now().format(formatter), sendObject);
            OutputStream out = Files.newOutputStream(LOG_FILE,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
            out.write(newStr.getBytes());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
