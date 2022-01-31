package ua.goit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.goit.model.UserDevelopers;
import ua.goit.services.UserDevelopersService;

import java.util.List;

@RestController
@RequestMapping("/developers")
public class UserDevelopersController {

    @Autowired
    private UserDevelopersService userDevelopersService;

    @GetMapping
    public List<UserDevelopers> getAll() {
        return userDevelopersService.getAll();
    }

    @GetMapping
    @RequestMapping("/{param}")
    public UserDevelopers get(@PathVariable("param") Long id) {
        var user = new UserDevelopers();
        user.setLastName("Vaka");
        user.setId(id);
        user.setFirstName("Gordon");
        return user;
    }
}
