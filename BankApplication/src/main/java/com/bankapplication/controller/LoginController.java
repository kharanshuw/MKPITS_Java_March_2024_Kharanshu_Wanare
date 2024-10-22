package com.bankapplication.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * LoginController handles all admin-related requests and actions.
 */
@Controller
public class LoginController {
	
    // This sets up the logger for the AdminController class.
	    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * Handles GET requests to the /login endpoint.
     * Logs the access and returns the login view.
     *
     * @return the name of the login view
     */
    @GetMapping("/login")
    public String loginuser() {
    	logger.info("inside login method");
      
        return "login/login";
    }

    /**
     * Handles GET requests to the root (/) endpoint.
     * Logs the access and returns the home view.
     *
     * @return the name of the home view
     */
    @GetMapping("/")
    public String homepage() {
        logger.info("home page called inside login controller");
        return "home/home";
    }
    
    

}
