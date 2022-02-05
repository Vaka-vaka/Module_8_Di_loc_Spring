package ua.goit.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ua.goit.services.RolesService;
import ua.goit.validation.IsUnique;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@NoArgsConstructor(force = true)
@IsUnique(model = RolesService.class)
public class RolesDto {

    private UUID id;

    @NotBlank
    @Size(min=2)
    private String name;
}
