package com.bankapplication.exceptionhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Model model, Exception e) {
        model.addAttribute("msg", "An unexpected error occurred");

        logger.error("An unexpected error occurred" + e);

        return "redirect:/error";
    }

}
