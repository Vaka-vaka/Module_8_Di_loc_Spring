package ua.goit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.goit.model.Producers;
import ua.goit.services.ProducersService;
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

    @PostMapping("/new")
    public String create(Model model) {
        model.addAttribute("producer", new Producers());
        model.addAttribute("producers", producersService.getAllDto());
        return "producer";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable UUID id, Model model) {
        model.addAttribute("producer", producersService.get(id));
        model.addAttribute("producers", producersService.getAllDto());
        return "producer";
    }
}
