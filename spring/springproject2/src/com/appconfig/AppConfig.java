package com.appconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public Student s1() {
		Student student=new Student();
		
		student.setCityString("nagpur");
		student.setNameString("pratik");
		
		return student;
	}
}
