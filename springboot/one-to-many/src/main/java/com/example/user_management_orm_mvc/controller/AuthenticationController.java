package com.example.user_management_orm_mvc.controller;

import com.example.user_management_orm_mvc.dto.RequestDTO;
import com.example.user_management_orm_mvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {
    @GetMapping("/index")
    public String home()
    {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        RequestDTO user = new RequestDTO();
        model.addAttribute("user", user);
        return "register";
    }
    @PostMapping("/register/submit")
    public String registerUserAccount(Model model, RequestDTO user){
        User newUser = new User();
        model.addAttribute("name", user.getName());
        model.addAttribute("username", user.getUsername());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("role", user.getRole());
        model.addAttribute("address", user.getAddress());
        model.addAttribute("phoneNo", user.getPhoneNo());
        model.addAttribute("email", user.getEmail());

        return "success";
    }

}
