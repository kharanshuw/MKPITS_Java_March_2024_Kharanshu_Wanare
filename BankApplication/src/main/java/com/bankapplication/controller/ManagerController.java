package com.bankapplication.controller;

import com.bankapplication.dto.ResponseDto;
import com.bankapplication.getapplicationcontext.UserServiceAppContext;
import com.bankapplication.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);
    private UserServiceAppContext userServiceAppContext;
    private UserService userService;

    @Autowired
    public ManagerController(UserServiceAppContext userServiceAppContext, UserService userService) {
        super();
        this.userServiceAppContext = userServiceAppContext;
        this.userService = userService;
    }

    /**
     * Handles the request to display the manager home page. * @param model the
     * model to pass attributes to the view
     *
     * @return the view name of the manager home page
     */
    @GetMapping("/home")
    public String getManagerHome(Model model) {
        logger.info("getManagerHome method from ManagerController called successfully");
        try {
            // Return the view name for the manager home page
            return "home/manager/manager-home";
        } catch (Exception e) {
            logger.error("Exception occurred in getManagerHome method of ManagerController: {}", e.getMessage());

            model.addAttribute("e",
                    "Exception occurred in getManagerHome method of ManagerController:" + " " + e.getMessage());

            return "error/error";
        }

    }

    @GetMapping("/profile")
    public String getManagerProfile(Model model) {
        logger.info("/manager/profile called successfully");
        String email = userServiceAppContext.getLoggedInUserEmail();

        logger.info("logged in user email is " + email.toString());

        ResponseDto responseDto = userService.getLoggedInUserDetails(email);

        ArrayList<String> roleStrings = responseDto.getrolestring();

        model.addAttribute("roles", roleStrings);
        model.addAttribute("user", responseDto);

        return "home/manager/manager-profile-data";
    }
}
