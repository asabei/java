package HW11;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class StudentService {
    private final JdbcTemplate jdbcTemplate;
    private static final Path LOG_FILE = Path.of("src/main/java/HW11/database.log");
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Autowired
    public StudentService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void writeLog(String sendObject){
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

    public static List<String> readLog(LocalDateTime start, LocalDateTime end){
        try{
            List<String> in = Files.readAllLines(LOG_FILE);
            return in.stream()
                    .filter(line -> {
                        String str = line.substring(0, 19);
                        LocalDateTime time = LocalDateTime.parse(str, formatter);
                        return !time.isBefore(start) && !time.isAfter(end);
                    })
                    .toList();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostConstruct
    public void initDb() {
        String dropTable = "DROP TABLE IF EXISTS students";
        jdbcTemplate.execute(dropTable);
        writeLog(dropTable);

        String createTableStudent = "CREATE TABLE students (\n" +
                "    student_id SERIAL PRIMARY KEY,\n" +
                "    first_name VARCHAR(50) NOT NULL,\n" +
                "    last_name VARCHAR(50) NOT NULL,\n" +
                "    birth_date DATE,\n" +
                "    group_name VARCHAR(20)\n" +
                ");";
        jdbcTemplate.execute(createTableStudent);
        writeLog("CREATE TABLE students");

        String insertStudents = "INSERT INTO students (first_name, last_name, birth_date, group_name) VALUES\n" +
                "('Алексей', 'Иванов', '2000-05-15', 'CS-21'),\n" +
                "('Мария', 'Петрова', '2001-03-22', 'CS-21'),\n" +
                "('Иван', 'Сидоров', '1999-10-08', 'AI-22'),\n" +
                "('Елена', 'Кузнецова', '2000-12-30', 'AI-22'),\n" +
                "('Дмитрий', 'Васильев', '2001-07-14', 'CS-21'),\n" +
                "('Ольга', 'Новикова', '2000-01-18', 'BIO-20');";
        jdbcTemplate.execute(insertStudents);
        writeLog("INSERT INTO students");
    }
    private final RowMapper<Student> studentRowMapper = ((rs, rowNum) ->
                new Student(
                        rs.getLong("student_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getDate("birth_date").toLocalDate(),
                        rs.getString("group_name")

                ));
    public List<Student> getAll() {
        String sql = "SELECT * FROM students ORDER BY last_name";

        writeLog(sql);
        return jdbcTemplate.query(sql, studentRowMapper);
    }

    public Student getStudentById(Long id) {
        String sql = "SELECT * FROM students WHERE student_id = ?";
        writeLog(sql + " with student_id=" + id);
        return jdbcTemplate.queryForObject(sql, studentRowMapper, id);
    }

    public List<Student> getStudentsByGroup(String groupName) {
        String sql = "SELECT * FROM students WHERE group_name = ? ORDER BY last_name";
        writeLog(sql + " with groupName=" + groupName);
        return jdbcTemplate.query(sql, studentRowMapper, groupName);
    }
    public int updateStudent(Long id, String firstName, String groupName) {
        String sql = "UPDATE students SET first_name = ?, group_name = ? WHERE student_id = ?";
        String fullQuery = String.format("%s with student_id=%d, firstName=%s, groupName=%s",
                sql, id, firstName, groupName);
        writeLog(fullQuery);
        return jdbcTemplate.update(sql, firstName, groupName, id);
    }

    public int createStudent(Student student) {
        String sql = "INSERT INTO students (first_name, last_name, group_name) VALUES (?, ?, ?)";
        String fullQuery = String.format("%s with firstName=%s, lastName=%s, groupName=%s",
                sql, student.getFirstName(), student.getLastName(), student.getGroupName());
        writeLog(fullQuery);
        return jdbcTemplate.update(sql,
                student.getFirstName(), student.getLastName(), student.getGroupName());
    }

    public int deleteStudent(Long id) {
        String sql = "DELETE FROM students WHERE student_id = ?";
        writeLog(sql + " with student_id=" + id);
        return jdbcTemplate.update(sql, id);
    }















}
