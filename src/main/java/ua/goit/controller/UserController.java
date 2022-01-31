package ua.goit.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.goit.dto.UserDto;
import ua.goit.model.User;
import ua.goit.services.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDto get(@PathVariable UUID id) {
        return userService.get(id);
    }

    @PostMapping
    public void create(@RequestBody UserDto userDto) {
        userService.create(userDto);
        System.out.println(userDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable UUID id, @RequestBody UserDto userDto) {
        userService.update(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        userService.deleete(id);
    }
}
