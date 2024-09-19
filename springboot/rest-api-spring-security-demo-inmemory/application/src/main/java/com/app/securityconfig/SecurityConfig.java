package com.app.securityconfig;

import org.springframework.security.config.Customizer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


/**
 * Spring Security configuration class.
 * 
 * @author [Kharanshu Wanare]
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity // Enables method-level security
public class SecurityConfig {

    /**
     * Defines a security filter chain.
     * 
     * @param httpSecurity
     * @return SecurityFilterChain
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // Configure authorization for HTTP requests
        httpSecurity
            .authorizeHttpRequests(auth -> auth
                // Allow all GET requests to /api/
                .requestMatchers(HttpMethod.GET, "api/").permitAll()
                // Require EMPLOYEE role for GET requests to /api/home
                .requestMatchers(HttpMethod.GET, "api/home").hasRole("EMPLOYEE")
                // Require ADMIN role for GET requests to /api/home2
                .requestMatchers(HttpMethod.GET, "api/home2").hasRole("ADMIN")
                // Require authentication for all other requests
                .anyRequest().authenticated()
            );

        // Enable HTTP Basic authentication with default settings
        httpSecurity.httpBasic(Customizer.withDefaults());

        // Disable CSRF protection
        httpSecurity.csrf(c -> c.disable());

        return httpSecurity.build();
    }

    /**
     * Defines an in-memory user details manager.
     * 
     * @return InMemoryUserDetailsManager
     */
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        // Create user with ADMIN role
        UserDetails userDetails = User.builder()
            .username("pratik")
            .password("{noop}test123") // Store password in plain text (NOT RECOMMENDED)
            .roles("ADMIN")
            .build();

        // Create user with EMPLOYEE role
        UserDetails userDetails2 = User.builder()
            .username("kharanshu")
            .password("{noop}test123") // Store password in plain text (NOT RECOMMENDED)
            .roles("EMPLOYEE")
            .build();

        // Return user details manager with created users
        return new InMemoryUserDetailsManager(userDetails, userDetails2);
    }
}