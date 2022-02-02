package ua.goit.dto;

import lombok.Data;
import lombok.ToString;
import ua.goit.model.Producers;
import ua.goit.validation.UniqueValidation;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@ToString
@UniqueValidation
public class ProductsDto {

    @NotEmpty
    private String name;
    @NotEmpty
    private BigDecimal price;
    @NotEmpty
    private Producers producers;
}
