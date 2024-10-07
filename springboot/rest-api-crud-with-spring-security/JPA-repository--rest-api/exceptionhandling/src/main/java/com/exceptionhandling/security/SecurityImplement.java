package com.exceptionhandling.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityImplement {
	
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		
		UserDetails oneDetails=User.builder().username("pratik").roles("employee").password("{noop}123").build();
		
		UserDetails twoDetails=User.builder().username("kharanshu").roles("employee,admin").password("{noop}123").build();
		
		UserDetails threeDetails=User.builder().username("manthan").roles("employee,admin,manager").password("{noop}123").build();
		
		
		
		return new InMemoryUserDetailsManager(oneDetails,twoDetails,threeDetails);
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception

	{
		
		httpSecurity.authorizeHttpRequests(
				c->c.requestMatchers(HttpMethod.GET,"/api/students").hasRole("admin")
				
				);
		
		httpSecurity.httpBasic(Customizer.withDefaults());
		
		httpSecurity.csrf(c->c.disable());
		
		return httpSecurity.build();
	}


}
