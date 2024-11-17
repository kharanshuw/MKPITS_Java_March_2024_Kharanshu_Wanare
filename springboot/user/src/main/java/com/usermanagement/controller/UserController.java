package com.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.usermanagement.entity.*;
import org.springframework.web.bind.annotation.PostMapping;

import com.usermanagement.service.*;

@Controller
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/home")
	public String showhome() {
		return "home";
	}

	@GetMapping("/login")
	public String loginpage() {
		return "Login";
	}

	@GetMapping("/signup")
	public String usersignupform(Model model) {

		User user = new User();

		model.addAttribute("user", user);
		return "signupform";
	}

	@PostMapping("/register")
	public String registeruser(@ModelAttribute("user") User user) {
		user.setPassword("{noop}" + user.getPassword());
		
		
		System.out.println("saving register in controller"+user);

		userService.registerUser(user);

		return "Login";
	}

}
