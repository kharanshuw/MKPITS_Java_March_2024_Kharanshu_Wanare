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

    @GetMapping("/register")
    public String registerUser(Model model) {
        
        
        logger.info("registration page called ");
        
        RequestDto requestDto = new RequestDto();
        model.addAttribute("requestDto", requestDto);
        return "registration/registeration";
    }

    @GetMapping("/successful")
    public String successfullRegisterd() {
        
        return "successful/index";
    }

    @PostMapping("/processregistration")
    public String registerUser(@Valid @ModelAttribute("requestDto") RequestDto requestDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            logger.error("error found in user registration below is requestdto recived from form ");
            logger.error(requestDto.toString());

            bindingResult.getFieldErrors().forEach(error -> {
                System.out.println(
                        "field" + error.getField() + ",error:" + error.getDefaultMessage()
                );
            });


            
            return "registration/registeration"; // return the registration page if there are errors
        }

        System.out.println("register processing started successully");
        
        

        System.out.println(requestDto);

        userServiceImpl.createuser(requestDto);


        return "redirect:/successful"; // redirect to the success page after successful registration
    }

}
