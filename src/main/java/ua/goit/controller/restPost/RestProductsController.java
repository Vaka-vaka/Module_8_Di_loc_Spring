package ua.goit.controller.restPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ua.goit.dto.ProductsDto;
import ua.goit.dto.UserDto;
import ua.goit.services.ProductsService;
import ua.goit.services.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("rest/products")
public class RestProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping
    public List<ProductsDto> getAllDto() {
        return productsService.getAllDto();
    }

    @GetMapping("/{id}")
    public ProductsDto get(@PathVariable UUID id) {
        return productsService.getDto(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin')")
    public void create(@RequestBody @Valid ProductsDto productsDto) {
        productsService.create(productsDto);
        System.out.println(productsDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable UUID id, @RequestBody ProductsDto productsDto) {
        productsService.update(id, productsDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        productsService.delete(id);
    }
}
