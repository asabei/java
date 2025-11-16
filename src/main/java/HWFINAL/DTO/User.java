package HWFINAL.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotBlank(message = "FirstName не должен быть пустым")
    private String firstName;

    @NotBlank(message = "LastName не должен быть пустым")
    private String lastName;

    @NotNull(message = "birthDay не должен быть null")
    private LocalDate birthDay;

    @NotNull(message = "DepartmentId не должен быть null")
    private Integer departmentId;

    public User(long id, String firstName, String lastName, LocalDate birthDay, String nameDepartment) {
    }
}
