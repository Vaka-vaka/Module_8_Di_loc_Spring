package ua.goit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.goit.model.User;
import ua.goit.services.UserService;

import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("users", service.getAll());
        return "users";
    }

    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", service.getAll());
        return "user";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable UUID id, Model model) {
        model.addAttribute("user", service.getEdit(id));
        model.addAttribute("users", service.getAll());
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
//    public String update(@ModelAttribute @Valid CategoryDto dto) {
//        service.update(dto);
//        return "redirect:/categories";
//    }
//
//    @GetMapping(value = "/{id}/image", produces = MediaType.IMAGE_JPEG_VALUE)
//    @ResponseBody
//    public byte[] getImage(@PathVariable Long id) {
//        return service.getImage(id);
//    }

}
