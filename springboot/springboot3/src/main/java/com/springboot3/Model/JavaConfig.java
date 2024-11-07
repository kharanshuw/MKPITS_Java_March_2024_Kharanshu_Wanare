package com.springboot3.Model;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration

public class JavaConfig {

	@Bean
	@Lazy
	public Account loanAccount() {
		return new LoanAccount();
	}
}
