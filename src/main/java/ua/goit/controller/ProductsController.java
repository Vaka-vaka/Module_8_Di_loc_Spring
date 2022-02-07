package ua.goit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.goit.model.Products;
import ua.goit.services.ProductsService;
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

    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("product", new Products());
        model.addAttribute("products", service.getAllDto());
        return "product";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable UUID id, Model model) {
        model.addAttribute("product", service.get(id));
        model.addAttribute("products", service.getAllDto());
        return "product";
    }


}
