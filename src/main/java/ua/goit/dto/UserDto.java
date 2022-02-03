package ua.goit.dto;

import lombok.Data;
import lombok.ToString;
import ua.goit.validation.IsUnique;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@ToString
@IsUnique(table = "users", field = "first_name")
public class UserDto {

    @NotEmpty
    private String email;
    private  String lastName;
    @Size(min = 5, message = "First name should be at least 5 character.")
    private String firstName;
    @NotEmpty
    @Size(min = 5, message = "Password should be at least 5 character.")
    private String password;
}
