package com.usermanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.usermanager.services.StudentServiceIMPL;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.usermanager.entity.Student;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class StudentController {

	StudentServiceIMPL studentServiceIMPL;

	@Autowired
	public StudentController(StudentServiceIMPL studentServiceIMPL) {
		super();
		this.studentServiceIMPL = studentServiceIMPL;
	}

	

	@PostMapping("/processtudent")
	public RedirectView processStudent(@ModelAttribute Student student) {
		studentServiceIMPL.saveStudent(student);
		RedirectView redirectView = new RedirectView("/list");
		return redirectView;
	}

	@GetMapping("/list")
	public String showstudentlist(Model model) {
		List<Student> list = studentServiceIMPL.findallstudnetList();
		model.addAttribute("list", list);
		return "index";
	}

	@GetMapping("/show_add_student_form")
	public String showAddStudentForm(Model model) 
	{
	Student student = new Student();
	model.addAttribute("student",student);
		return "save_student";
	}
	
	@GetMapping("/delete")
	public RedirectView deletestudent(@RequestParam("id") int id)
	{
		RedirectView redirectView = new RedirectView();
		studentServiceIMPL.deletestudent(id);
		String urlString="/list";
		
		redirectView.setUrl(urlString);
		
		return redirectView;
	}
	
	@GetMapping("/view")
	public String getStudent(@RequestParam("id") int id,Model model) {
		Student student = studentServiceIMPL.findbyidStudent(id);
		model.addAttribute("student",student);
		return "student_data";
	}
	
	@GetMapping("/update")
	public String updatestudent(@RequestParam("id") int id,Model model)
	{
		Student student = studentServiceIMPL.findbyidStudent(id);
		model.addAttribute("student",student);
		return "update_student";
	}
	
	@PostMapping("/processupdate")
	public RedirectView processUpdate(@ModelAttribute Student entity) {
		
		studentServiceIMPL.updatestudent(entity);
		
		
		RedirectView redirectView = new RedirectView();
		
		String urlString ="/list";
		
		redirectView.setUrl(urlString);
		
		return redirectView;
	}
	
	
	
}
