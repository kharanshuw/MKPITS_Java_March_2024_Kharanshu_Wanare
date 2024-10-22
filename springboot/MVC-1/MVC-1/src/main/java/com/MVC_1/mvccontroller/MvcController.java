package com.MVC_1.mvccontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/api" , method = RequestMethod.POST)
public class MvcController {

	@GetMapping("/hello")
	public String displayString(Model model)
	{
		
		model.addAttribute("message","welcome to mvc");
		
		return "hello";
				
	}
	
	@GetMapping("/showform")
	public String showForm()
	{
		return "showform";
	}
	
	
}
