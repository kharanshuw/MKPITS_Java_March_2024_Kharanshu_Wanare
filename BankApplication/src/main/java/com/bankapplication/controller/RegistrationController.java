package com.bankapplication.controller;

import com.bankapplication.dto.RequestDto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.slf4j.*;

import com.bankapplication.service.*;

import jakarta.validation.Valid;


@Controller
public class RegistrationController {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    private UserServiceImpl userServiceImpl;

    @Autowired
    public RegistrationController(UserServiceImpl userServiceImpl) {
        super();
        this.userServiceImpl = userServiceImpl;
    }

    /**
     * Handles GET requests to the /register endpoint.
     * Logs the access and adds a new RequestDto object to the model.
     *
     * @param model the model to which the RequestDto object is added
     * @return the name of the registration view
     */
    @GetMapping("/register")
    public String registerUser(Model model) {
        
        
        logger.info("registration page called ");
        
        RequestDto requestDto = new RequestDto();
        model.addAttribute("requestDto", requestDto);
        return "registration/registeration";
    }
    
    
    
    
    /**
     * Handles GET requests to the /successful endpoint.
     *
     * @return the name of the success view
     */
    @GetMapping("/successful")
    public String successfullRegisterd() {
        
        return "successful/index";
    }




    /**
     * Handles POST requests to the /processregistration endpoint.
     * Validates the RequestDto object and processes the user registration.
     *
     * @param requestDto the RequestDto object containing user registration data
     * @param bindingResult the result of the validation and binding
     * @return the name of the view to be returned
     */

    @PostMapping("/processregistration")
    public String registerUser(@Valid @ModelAttribute("requestDto") RequestDto requestDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            logger.error("Error found in user registration. Below is the RequestDto received from form:");
            logger.error(requestDto.toString());

            bindingResult.getFieldErrors().forEach(error -> {
                System.out.println(
                        "field" + error.getField() + ",error:" + error.getDefaultMessage()
                );
            });


            
            return "registration/registeration"; // return the registration page if there are errors
        }

       
        
        logger.info("register processing started successully");
        
        logger.info(requestDto.toString());
        // Create the user with the provided data

        userServiceImpl.createuser(requestDto);


        return "redirect:/successful"; // redirect to the success page after successful registration
    }

}
