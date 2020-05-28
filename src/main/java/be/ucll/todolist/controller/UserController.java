package be.ucll.todolist.controller;

import be.ucll.todolist.model.DTO.CreateUserDTO;
import be.ucll.todolist.model.DTO.UserDTO;
import be.ucll.todolist.model.domain.Task;
import be.ucll.todolist.model.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @GetMapping
    public String showTasks(){
        return "redirect:/task";
    }

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String getCreateUser(Model model) {
        model.addAttribute("user", new CreateUserDTO());
        return "signupform";
    }

    @PostMapping("/signup")
    public String postCreateUser(@ModelAttribute("user") @Valid CreateUserDTO user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signupform";
        }
        userService.createUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLoginForm() {
        return "signinform";
    }
}
