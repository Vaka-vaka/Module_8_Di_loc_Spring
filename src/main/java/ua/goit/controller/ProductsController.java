package ua.goit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.goit.model.Products;
import ua.goit.services.ProducersService;
import ua.goit.services.ProductsService;

import java.math.BigDecimal;
import java.util.UUID;

@Controller
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;
    @Autowired
    private ProducersService producersService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("products", productsService.getAllDto());
        return "products";
    }

    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("product", new Products());
        model.addAttribute("products", productsService.getAll());
        model.addAttribute("producers", producersService.getAll());
        return "product";
    }

    @PostMapping
    public String saveNew(@ModelAttribute Products products) {
        productsService.save(products);
        return "redirect:/products";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable UUID id, Model model) {
        model.addAttribute("product", productsService.get(id));
        model.addAttribute("products", productsService.getAllDto());
        return "product";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable UUID id,
                                 @RequestParam String name,
                                 @RequestParam BigDecimal price,
                                 @RequestParam(required = false)  String parent) {
 //       productsService.save();
        return "redirect:/products";
    }
}
