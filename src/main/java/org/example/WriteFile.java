package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    public static void writeFile(StringBuffer stringBuffer, String name){
        try (FileWriter writer = new FileWriter(name)) {
            writer.write(stringBuffer.toString());
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
