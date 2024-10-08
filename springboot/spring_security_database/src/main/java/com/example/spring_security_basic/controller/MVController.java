package com.example.spring_security_basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MVController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/login")
    public String loginPage(){
        return "login_page";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }


    @GetMapping("/access_denied")
    public String accessDenied() {
        return "access_denied";
    }
}
