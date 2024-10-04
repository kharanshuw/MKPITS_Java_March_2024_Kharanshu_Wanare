package com.example.user_management_orm_mvc.controller;

import com.example.user_management_orm_mvc.entity.User;
import com.example.user_management_orm_mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String allUsersList(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user_list";
    }

    @GetMapping("/new")
    public String createNewUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user_form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users/list";
    }

    @GetMapping("/view/{id}")
    public String viewUserDetails(@PathVariable("id") int id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user_details";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteById(id);
        return "redirect:/users/list";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable int id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user_form";
    }
}
//make another controller for login