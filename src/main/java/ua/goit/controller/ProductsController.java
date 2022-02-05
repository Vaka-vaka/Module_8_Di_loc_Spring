package ua.goit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.goit.dto.ProductsDto;
import ua.goit.model.Products;
import ua.goit.model.User;
import ua.goit.services.ProductsService;
import ua.goit.services.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService service;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("products", service.getAllDto());
        return "products";
    }

    @PostMapping("/new")
    public String create(Model model) {
        model.addAttribute("product", new Products());
        model.addAttribute("products", service.getAllDto());
        return "product";
    }

    @PostMapping("/{id}")
    public String edit(@PathVariable UUID id, Model model) {
        model.addAttribute("product", service.get(id));
        model.addAttribute("products", service.getAllDto());
        return "product";
    }
}
