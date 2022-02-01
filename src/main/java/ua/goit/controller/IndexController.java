package ua.goit.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

public class IndexController {

    public String IndexController;

    @GetMapping
    @PreAuthorize("hasAuthority('user')")
    public String index() {
        return "Hello";
    }
}
