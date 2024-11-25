package com.consume_api_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

	private RestTemplate restTemplate;

	@Autowired
	public WeatherService(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	
	public String consumeApi() {
		return restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/1", String.class);
	}

}
