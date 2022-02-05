package ua.goit.dto;

import lombok.Data;
import lombok.ToString;
import ua.goit.validation.IsUnique;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Data
@ToString
@IsUnique
public class ProducersDto {

    private UUID id;
    @NotEmpty
    private String name;
}
