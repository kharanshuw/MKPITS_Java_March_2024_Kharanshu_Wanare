package com.bankapplication.controller;

import com.bankapplication.dto.ResponseDto;

import com.bankapplication.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.slf4j.*;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	private UserServiceImpl userService;

	@Autowired
	public UserController(UserServiceImpl userService) {
		this.userService = userService;
	}

	@GetMapping("/home2")
	public String homepage2(Model model, HttpServletRequest httpServletRequest) {

		logger.info("homepage2 method from usercontroller class called ");

		String emailString = userService.getLoggedInUserEmail();

		logger.info("the user logged in is :" + emailString);

		System.out.println("the user logged in is :" + emailString);

		model.addAttribute("email", emailString);

		if (httpServletRequest.isUserInRole("USER")) {

			logger.info("User home page called after successful login inside UserController");

			return "home/userhome/userhome";

		} else if (httpServletRequest.isUserInRole("ADMIN")) {

			logger.info("Admin home page called after successful login inside UserController");
			return "home/adminhome/home2";

		}

		else {

			logger.error("User role not identified, redirecting to error page");
			return "error/error";
		}

	}

	@GetMapping("/access-denied")
	public String accessdenied() {
		return "error/access-denied.html";
	}

	@GetMapping("/userprofile")
	public String userprofile(Model model) {
		logger.info("userprofile method from usercontroller class called ");

		String emailString = userService.getLoggedInUserEmail();

		logger.info("the user logged in is :" + emailString);

		System.out.println("the user logged in is :" + emailString);

		ResponseDto user = userService.getLoggedInUserDetails(emailString);

		if (user == null) {
			return null;
		} else {
			model.addAttribute("user", user);
			return "home/userhome/userprofiledetails.html";
		}
	}
}
