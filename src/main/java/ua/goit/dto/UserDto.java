package ua.goit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import ua.goit.validation.IsUnique;
import ua.goit.validation.OnUpdate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@ToString
@IsUnique(table = "users", field = "first_name")
public class UserDto {

    private UUID id;
    @NotEmpty
    private String email;
    private  String lastName;
    @Size(min = 5, message = "First name should be at least 5 character.")
    private String firstName;
    @NotEmpty
    @Size(min = 5, message = "Password should be at least 5 character.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotEmpty(groups = {OnUpdate.class})
    private Set<RolesDto> roles = new HashSet<>();
}
