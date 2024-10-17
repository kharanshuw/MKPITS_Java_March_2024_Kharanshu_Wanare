package com.bankapplication.controller;

import com.bankapplication.dto.ResponseDto;
import com.bankapplication.getapplicationcontext.UserServiceAppContext;
import com.bankapplication.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.slf4j.*;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserServiceImpl userService;

    private UserServiceAppContext userServiceAppContext;

    @Autowired
    public UserController(UserServiceImpl userService, UserServiceAppContext userServiceAppContext) {
        this.userService = userService;
        this.userServiceAppContext = userServiceAppContext;
    }

    @GetMapping("/home2")
    public String homepage2(Model model, HttpServletRequest httpServletRequest) {

        logger.info("homepage2 method from usercontroller class called ");

        String emailString = userServiceAppContext.getLoggedInUserEmail();

        logger.info("the user logged in is :" + emailString);

        System.out.println("the user logged in is :" + emailString);

        model.addAttribute("email", emailString);

        if (httpServletRequest.isUserInRole("USER") &&   httpServletRequest.isUserInRole("ADMIN") ) {

            logger.info("multi profile home page called after successful login inside UserController");

            return "home/adminhome/multiple-user";

        } else if (httpServletRequest.isUserInRole("ADMIN")) {

            logger.info("Admin home page called after successful login inside UserController");
            return "home/adminhome/adminhome";

        } else if (httpServletRequest.isUserInRole("USER")) {


            logger.info("User home page called after successful login inside UserController");

            return "home/userhome/userhome";

        } else {

            logger.error("User role not identified, redirecting to error page");
            return "error/error";
        }

    }

    @GetMapping("/access-denied")
    public String accessdenied() {
        return "error/access-denied.html";
    }



    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/user/profile")
    public String userprofile(Model model, HttpServletRequest request) {
        logger.info("userprofile method from usercontroller class called ");

        String emailString = userServiceAppContext.getLoggedInUserEmail();

        logger.info("the user logged in is :" + emailString);

        System.out.println("the user logged in is :" + emailString);

        ResponseDto user = userService.getLoggedInUserDetails(emailString);

        if (user == null) {
            return "error/error";
        } else {
              if (request.isUserInRole("USER")) {
                // Handle user profile
                logger.info("user provile invoked");
                model.addAttribute("user", user);
                return "home/userhome/userprofiledetails.html";
            } else {
                // Redirect to error page if no valid role is found
                logger.error("error occured while handling userprofile request");
                return "error/error";
            }
        }
    }



}
