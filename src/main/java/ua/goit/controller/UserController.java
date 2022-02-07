package ua.goit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.goit.dto.UserDto;
import ua.goit.model.User;
import ua.goit.services.RolesService;
import ua.goit.services.UserService;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@PreAuthorize("hasAuthority('admin')")
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;
    @Autowired
    private RolesService rolesService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("users", service.getAll());
        model.addAttribute("roles", rolesService.getAll());
        return "users";
    }

    @PostMapping("/new")
    public String create(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", service.getAll());
        model.addAttribute("roles", rolesService.getAll());
        return "user";
    }

    @GetMapping("/{id}")
//      @PostMapping("/{id}")
    public String edit(@PathVariable UUID id, Model model) {
        model.addAttribute("user", service.getEdit(id));
        model.addAttribute("users", service.getAll());
        model.addAttribute("roles", rolesService.getAll());
        return "user";
    }

//    @PostMapping("/{id}/upload")
//    public String uploadImg(@RequestParam MultipartFile file,
//                            RedirectAttributes attributes,
//                            @PathVariable Long id) {
//        service.uploadImage(id, file);
//        attributes.addFlashAttribute("message",
//                "File was uploaded. " + file.getName());
//        return "redirect:/categories/" + id;
//    }
//
//    @PostMapping("/{id}")
//    public String update(@ModelAttribute @Valid UserDto userDto) {
//        service.update(userDto);
//        return "redirect:/categories";
//    }
//
//    @GetMapping(value = "/{id}/image", produces = MediaType.IMAGE_JPEG_VALUE)
//    @ResponseBody
//    public byte[] getImage(@PathVariable Long id) {
//        return service.getImage(id);
//    }

}
