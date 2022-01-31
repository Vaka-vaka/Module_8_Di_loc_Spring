package ua.goit.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class UserDto {

    @NotEmpty
    private String email;
    private  String lastName;
    @Size(min = 5, message = "First name should be at least 5 character.")
    private String firstName;
//    @JsonIgnore //пароль через PostMapping, якщо убрать
    @Size(min = 5, message = "Password should be at least 5 character.")
    private String password;
}
