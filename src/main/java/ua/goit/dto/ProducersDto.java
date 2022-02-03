package ua.goit.dto;

import lombok.Data;
import lombok.ToString;
import ua.goit.validation.IsUnique;

import javax.validation.constraints.NotEmpty;

@Data
@ToString
@IsUnique
public class ProducersDto {

    @NotEmpty
    private String name;
}
