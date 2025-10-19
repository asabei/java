package Lesson6HW;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadFile {
    public static ArrayList<Person> readFile(String path) {
        ArrayList<Person> students = new ArrayList<>();
        try {
            BufferedReader inputLine = new BufferedReader(new FileReader(path));
            String line;
            while ((line = inputLine.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                String [] parts = line.split(" ");
                //System.out.println(Arrays.toString(parts));
                students.add(new Person(parts[0], parts[1], Integer.parseInt(parts[2])));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
}
