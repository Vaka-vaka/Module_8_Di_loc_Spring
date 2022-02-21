package ua.goit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.goit.config.AccessForAdmin;
import ua.goit.dto.ProducersDto;
import ua.goit.services.ProducersService;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping("/producers")
public class ProducersController {

    @Autowired
    private ProducersService producersService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("producers", producersService.getAll());
        return "producers";
    }

//    @PostMapping("/new")
//    public String create(Model model) {
//        model.addAttribute("producer", new Producers());
//        model.addAttribute("producers", producersService.getAllDto());
//        return "producer";
//    }
//
//    @GetMapping("/{id}")
//    public String edit(@PathVariable UUID id, Model model) {
//        model.addAttribute("producer", producersService.get(id));
//        model.addAttribute("producers", producersService.getAllDto());
//        return "producer";
//    }

    @GetMapping("/{id}")
    @AccessForAdmin
    public String get(@PathVariable UUID id,
                      Model model) {

        model.addAttribute("producer", producersService.get(id));

        return "producer";
    }

    @AccessForAdmin
    @PostMapping("/new")
    public String getNew(Model model) {

        model.addAttribute("producer", new ProducersDto());
        model.addAttribute("producers", producersService.getAllDto());

        return "producer";
    }

    @PostMapping
    @AccessForAdmin
    public void create(@Valid @RequestBody ProducersDto dto) {
        producersService.create(dto);
    }

    @PutMapping("/{id}")
    @AccessForAdmin
    public void update(@PathVariable UUID id,
                       @RequestBody ProducersDto dto) {

        producersService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @AccessForAdmin
    public void delete(@PathVariable UUID id) {
        producersService.delete(id);
    }
}
