package ua.goit.controller.restPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ua.goit.dto.UserDto;
import ua.goit.services.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rest/users")
public class RestUserController {

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
    @PreAuthorize("hasAuthority('admin')")
    public void create(@RequestBody @Valid UserDto userDto) {
        userService.create(userDto);
        System.out.println(userDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable UUID id, @RequestBody UserDto userDto) {
        userService.update(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        userService.delete(id);
    }
}
