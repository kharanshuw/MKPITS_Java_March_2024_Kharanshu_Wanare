package com.MVC_1.mvccontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.MVC_1.entity.Student;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/api" , method = RequestMethod.POST)
public class MvcController {

	@GetMapping("/hello")
	public String displayString(Model model)
	{
		
		model.addAttribute("message","welcome to mvc");
		
		return "hello";
				
	}
	
/*	@GetMapping("/showformv1")
	public String showForm()
	{
		return "showform";
	}
	*/
	
	
	@GetMapping("/showformv2")
	public String showFormv2(Model model)
	{
		Student student = new Student();
		
		model.addAttribute("student",student);
		
		return "showform2";
	}
	
	
	/*@GetMapping("/processform")
	public String processform(HttpServletRequest request,Model model)
	{
		String nameString=request.getParameter("nm");
		model.addAttribute("myname",nameString);
		return "processform";
	}*/
	
	@PostMapping("/processformv2")
	public String processformv2(@ModelAttribute("student") Student student,Model model)
	{
		model.addAttribute("student",student);
		return "processformv2";
	}
	
}
