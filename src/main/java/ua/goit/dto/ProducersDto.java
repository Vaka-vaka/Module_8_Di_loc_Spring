package ua.goit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import ua.goit.model.Producers;
import ua.goit.validation.IsUnique;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Data
@IsUnique(
        model = Producers.class,
        field = "name",
        message = "Producer's name not unique."
)
public class ProducersDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID id;
    @NotEmpty
    private String name;
}
