package com.springboot_mvc_crud_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.springboot_mvc_crud_demo.entity.Student;
import com.springboot_mvc_crud_demo.service.StudentService;




/**
 * Controller class for handling student-related requests.
 */
@Controller
@RequestMapping("/api")
public class StudentController {

private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	/**
     * Test method to display a simple "hello" page.
     */
	@GetMapping("/h")
	public String testhello() {
		return "hello";
	}

	 /**
     * Retrieves and displays a list of all students.
     */
	
	@GetMapping("/getstudents")
	public String getAllStudent(Model model) {
		List<Student> students = studentService.findAll();
		model.addAttribute("liststudent", students);
		return "all_student";
	}

    /**
     * Displays a form for adding a new student.
     */
	@GetMapping("/show_student_form")
	public String showformforadd(Model model) {
		Student student = new Student();

		model.addAttribute("student", student);

		return "student_form";
	}

	 /**
     * Saves a new student to the database and redirects to the student list page.
     */
	@PostMapping("/save")
	public RedirectView saveStudent(@ModelAttribute("student") Student student) {
		studentService.addStudent(student);
		/*
		 * when the user clicks Save button on a form to create a new item, he will be
		 * redirected to the show all student page.
		 */
		RedirectView redirectView = new RedirectView("/api/getstudents");
		return redirectView;
	}

	
	/**
     * Retrieves a student by ID and displays a form for updating their information.
     */
	@GetMapping("/studentUpdate")
	public String updatestudent(@RequestParam("id") int theid, Model model) {
		Student student = studentService.findById(theid);
		model.addAttribute("student", student);

		String nameString = "updatestudentform";
		return nameString;
	}
	
	@GetMapping("/delete")
	public RedirectView deleteStudent(@RequestParam("id") int id)
	{
		RedirectView redirectView = new RedirectView();
		
		studentService.deleteStudent(id);
		
		String urlString="/api/getstudents";
		redirectView.setUrl(urlString);
		
		
		return redirectView;
	}
	
	
}
