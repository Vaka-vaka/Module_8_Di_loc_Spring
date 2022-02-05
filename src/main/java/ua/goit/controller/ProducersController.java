package ua.goit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.goit.dto.ProducersDto;
import ua.goit.services.ProducersService;

import javax.validation.Valid;
import java.util.List;
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


}
