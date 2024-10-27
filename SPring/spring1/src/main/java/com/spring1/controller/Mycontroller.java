package com.spring1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontroller {

	@Value("${company.name}")
	public String compantString;
	
	@GetMapping("/")
	public String printname() {
		System.out.println(compantString);
		return "hello ";
	}
}
