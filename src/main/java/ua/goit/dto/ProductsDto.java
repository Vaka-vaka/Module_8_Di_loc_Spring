package ua.goit.dto;

import lombok.Data;
import lombok.ToString;
import ua.goit.model.Producers;
import ua.goit.model.Products;
import ua.goit.validation.IsUnique;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@ToString
@IsUnique(field = "first_name", model = Products.class)
public class ProductsDto {

    private UUID id;
    @NotEmpty
    private String name;

    private BigDecimal price;

    private Producers producers;
}
