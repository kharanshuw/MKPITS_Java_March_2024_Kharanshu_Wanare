package com.springboot_mvc_crud_demo.controller;

import java.util.List;

import com.springboot_mvc_crud_demo.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot_mvc_crud_demo.service.ImplStudentServices;
import com.springboot_mvc_crud_demo.service.StudentService;

@Controller
@RequestMapping("/api")
public class StudentController {

	StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping("/h")
	public String testhello() {
		return "hello";
	}

	@GetMapping("/getstudents")
	public String getAllStudent(Model model) {
		List<Student> students = studentService.findAll();
		model.addAttribute("liststudent", students);
		return "all_student";
	}

	@GetMapping("/show_student_form")
	public String showformforadd(Model model) {
		Student student = new Student();

		model.addAttribute("student", student);

		return "student_form";
	}

	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.addStudent(student);
		return "redirect:/all_student";
	}

	@GetMapping("/studentUpdate")
	public String updatestudent(@RequestParam("id") int theid,Model model) {
		Student student=studentService.findById(theid);
		model.addAttribute("student",student);
		
		String nameString="updatestudentform";
		return nameString;
	}
	
}
