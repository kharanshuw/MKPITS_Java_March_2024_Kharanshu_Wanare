package com.bankapplication.controller;

import com.bankapplication.dto.ResponseDto;
import com.bankapplication.getapplicationcontext.UserServiceAppContext;
import com.bankapplication.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import org.slf4j.*;

import jakarta.servlet.http.HttpServletRequest;


/*
 * This class serves as a controller for handling user related operations.
 * It manages HTTP requests related to user userprofiledata and more.
 *
 * Annotations:
 * - @Controller: Indicates that this class is a Spring MVC controller.
 *
 */
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

    /**
     * Handles GET requests to the /home2 endpoint.
     * Logs the access and determines the appropriate home page based on user roles.
     *
     * @param model              the model to which attributes are added
     * @param httpServletRequest the HTTP request to check user roles
     * @return the name of the view to be returned
     */
    @GetMapping("/home2")
    public String homepage2(Model model, HttpServletRequest httpServletRequest) {

        logger.info("homepage2 method from usercontroller class called ");

        String emailString = userServiceAppContext.getLoggedInUserEmail();

        logger.info("the user logged in is :" + emailString);

        model.addAttribute("email", emailString);

        if (httpServletRequest.isUserInRole("USER") && httpServletRequest.isUserInRole("ADMIN")) {

            logger.info("USER AND ADMIN  profile home page called after successful login inside UserController");

            return "home/adminhome/multiple-user";

        } else if (httpServletRequest.isUserInRole("USER") && httpServletRequest.isUserInRole("MANAGER")) {

            logger.info("USER AND MANAGER  profile home page called after successful login inside UserController");

            return "home/adminhome/multiple-user";
        } else if (httpServletRequest.isUserInRole("ADMIN") && httpServletRequest.isUserInRole("MANAGER")) {
            logger.info("ADMIN AND MANAGER profile home page called after successful login inside UserController");

            return "home/adminhome/multiple-user";
        } else if (httpServletRequest.isUserInRole("ADMIN")) {

            logger.info("Admin home page called after successful login inside UserController");
            return "home/adminhome/adminhome";

        } else if (httpServletRequest.isUserInRole("USER")) {


            logger.info("User home page called after successful login inside UserController");

            return "home/userhome/userhome";

        } else if (httpServletRequest.isUserInRole("MANAGER")) {
            logger.info("MANAGER home page called after successful login inside UserController");

            return "home/manager/dashboard";
        } else {

            logger.error("User role not identified, redirecting to error page");
            return "redirect:/access-denied";
        }

    }

    /**
     * Handles GET requests to the /access-denied endpoint.
     * Logs the access and returns the access denied view.
     *
     * @return the name of the access denied view
     */
    @GetMapping("/access-denied")
    public String accessdenied() {
        logger.error("error occured redirecting to error/access-denied");
        return "error/access-denied";
    }

    /**
     * Handles GET requests to the /user/profile endpoint.
     * Logs the access and retrieves the logged-in user's profile details.
     *
     * @param model   the model to which attributes are added
     * @param request the HTTP request to check user roles
     * @return the name of the view to be returned
     */
    @GetMapping("/user/profile")
    public String userprofile(Model model, HttpServletRequest request) {
        logger.info("userprofile method from usercontroller class called ");

        String emailString = userServiceAppContext.getLoggedInUserEmail();

        logger.info("the user logged in is :" + emailString);

        ResponseDto user = userService.getLoggedInUserDetails(emailString);

        if (user == null) {
            return "redirect:/error";
        }

        if (request.isUserInRole("USER")) {
            // Handle user profile
            logger.info("user provile invoked");
            model.addAttribute("user", user);
            return "home/userhome/userprofiledetails";
        } else {
            // Redirect to error page if no valid role is found
            logger.error("error occured while handling userprofile request");
            return "redirect:/access-denied";
        }

    }

    /**
     * Handles GET requests to the /error endpoint.
     * Logs the access and returns the error view.
     *
     * @return the name of the error view
     */
    @GetMapping("/error")
    public String error() {
        logger.error("error occured redirecting to /error ");
        return "error/error";
    }


    /**
     * This method handles all exceptions that are not explicitly caught elsewhere in the application.
     * It is annotated with @ExceptionHandler to indicate that it should be invoked when an Exception is thrown.
     */
    @ExceptionHandler(Exception.class)
    public String handleException(Exception exception,Model model) {
        logger.error("exception occured");
        logger.error(exception.toString());
        model.addAttribute("e",exception.getMessage());
        model.addAttribute("r", HttpStatus.BAD_REQUEST);
        return "error/error";
    }

}
