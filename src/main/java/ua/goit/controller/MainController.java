package ua.goit.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainPage(Authentication authentication,
                           Map<String, Object> model) {
        model.put("userName", authentication.getName());
        return "main";
    }
}
