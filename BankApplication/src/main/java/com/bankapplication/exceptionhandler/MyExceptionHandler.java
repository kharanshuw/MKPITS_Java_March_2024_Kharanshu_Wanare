package com.bankapplication.exceptionhandler;

import com.bankapplication.controller.UserController;
import org.hibernate.tool.schema.spi.SqlScriptException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ControllerAdvice
public class MyExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Model model,Exception e)
    {
        model.addAttribute("msg","An unexpected error occurred");
        
        logger.error("An unexpected error occurred"+e);
        
        return "redirect:/error";
    }
    
 }
