package ua.goit.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class UserDto {

    private String email;
    private  String lastName;
    private String firstName;
    @JsonIgnore //пароль через PostMapping, якщо убрать
    private String password;
}
