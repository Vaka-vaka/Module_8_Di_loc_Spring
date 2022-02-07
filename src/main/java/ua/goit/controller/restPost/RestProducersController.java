package ua.goit.controller.restPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ua.goit.dto.ProducersDto;
import ua.goit.dto.ProductsDto;
import ua.goit.services.ProducersService;
import ua.goit.services.ProductsService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("res/producers")
public class RestProducersController {

    @Autowired
    private ProducersService producersService;

    @GetMapping
    public List<ProducersDto> getAllDto() {
        return producersService.getAllDto();
    }

    @GetMapping("/{id}")
    public ProducersDto get(@PathVariable UUID id) {
        return producersService.get(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin')")
    public void create(@RequestBody @Valid ProducersDto producersDto) {
        producersService.create(producersDto);
        System.out.println(producersDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable UUID id, @RequestBody ProducersDto producersDto) {
        producersService.update(id, producersDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        producersService.delete(id);
    }
}
