package HW11;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String groupName;

    public Student() {}

    public Student(Long id, String firstName, String lastName, LocalDate birthDate, String groupName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.groupName = groupName;
    }

}
