package com.bankapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import  com.bankapplication.config.ApplicationConfig;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class BankapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankapplicationApplication.class, args);
	}

}
