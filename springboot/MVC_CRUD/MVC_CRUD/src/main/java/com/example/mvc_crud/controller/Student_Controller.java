package com.example.mvc_crud.controller;

import com.example.mvc_crud.model.Students;
import com.example.mvc_crud.service.StudentServiceImplementation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class Student_Controller {

    private final StudentServiceImplementation service;

    public Student_Controller(StudentServiceImplementation service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String allStudentList(Model model) {
        List<Students> students = service.findAll();
        model.addAttribute("list", students);
        return "allStudentList";
    }
}
