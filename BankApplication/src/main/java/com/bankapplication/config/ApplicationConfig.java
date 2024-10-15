package com.bankapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import com.bankapplication.auditconfig.ApplicationAudit;

@Configuration
public class ApplicationConfig {
	
	
	@Bean
	public AuditorAware<Integer> auditorAware(){
		return new ApplicationAudit();
	}

}
