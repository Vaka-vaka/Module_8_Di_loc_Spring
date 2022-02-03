package ua.goit.dto;

import lombok.Data;
import lombok.ToString;
import ua.goit.model.Producers;
import ua.goit.validation.IsUnique;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
@ToString
@IsUnique
public class ProductsDto {

    @NotEmpty
    private String name;

    private BigDecimal price;

    private Producers producers;
}
