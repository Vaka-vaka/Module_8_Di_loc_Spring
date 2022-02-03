package ua.goit.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class MainController {

    @Value("${myconfig.welcome.message}")
    private String wMsg;

    @GetMapping("/")
    public String mainPage(Authentication authentication,
                           HttpServletResponse response,
                           HttpServletRequest request,
                           Map<String, Object> model) {
        model.put("userName", authentication.getName());
        model.put("welcomeMsg", wMsg);
        return "main";
    }
}
