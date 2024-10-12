package com.consume_api_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consume_api_demo.service.WeatherService;

@RestController
public class HomeController {

	private WeatherService weatherService;

	@Autowired
	public HomeController(WeatherService weatherService) {
		super();
		this.weatherService = weatherService;
	}
	
	
	@GetMapping("/")
	public String getData() {
	return	weatherService.consumeApi();
	}

}
