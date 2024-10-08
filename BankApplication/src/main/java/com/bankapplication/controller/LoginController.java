package com.bankapplication.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/login")
    public String loginuser() {
    	logger.info("inside login method");
      
        return "login/login";
    }

    @GetMapping("/")
    public String homepage() {
        logger.info("home page called inside login controller");
        return "home/home";
    }
    
    

}
