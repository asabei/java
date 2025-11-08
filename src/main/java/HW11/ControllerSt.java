package HW11;


import Lesson7HW.LogerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/student")
public class ControllerSt {

    private final StudentService studentService;

    @Autowired
    public ControllerSt(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudens(){
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping("/group")
    public List<Student> getStudentsByGroup(@RequestParam String groupName) {
        return studentService.getStudentsByGroup(groupName);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateSt(@PathVariable Long id, @RequestParam String firstName, @RequestParam String groupName){
        int up = studentService.updateStudent(id, firstName, groupName);
        String resp = (up > 0) ? "updated" : "update error";
        return ResponseEntity.ok(resp);
    }

    @PostMapping
    public ResponseEntity createStudent(@RequestBody Student student) {
        int cr = studentService.createStudent(student);
        String resp = (cr > 0) ? "created" : "create error";
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id){
        int de = studentService.deleteStudent(id);
        String resp = (de > 0) ? "created" : "create error";
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/logs")
    public ResponseEntity<String> getLogs(
            @RequestParam String start,
            @RequestParam String end) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        LocalDateTime startTime = LocalDateTime.parse(start, formatter);
        LocalDateTime endTime = LocalDateTime.parse(end, formatter);
        List<String> logs = StudentService.readLog(startTime, endTime);
        StringBuilder res = new StringBuilder();
        for (String log: logs) {
            res.append(log).append("<br>");
        }
        return ResponseEntity.ok(res.toString());
    }






}
