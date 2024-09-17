package com.app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for testing purposes.
 * 
 * @author [Kharanshu Wanare]
 */
@RestController
@RequestMapping("/api") // Base path for all API endpoints
public class TestController {

    /**
     * secured endpoint, accessible by EMPLOYEE only.
     * 
     * @return "home"
     */
    @GetMapping("/home")
    public String homeTest() {
        return "home";
    }

    /**
     * secured endpoint, accessible by only admin.
     * 
     * @return "home2"
     */
    @GetMapping("/home2")
    public String home2() {
        return "home2";
    }

    /**
     * Secured endpoint, requires EMPLOYEE role.
     * 
     * @return "hello user"
     */
    @PreAuthorize("hasRole('EMPLOYEE')") // Method-level security annotation
    @GetMapping("/user")
    public String employeeEndpoint() {
        return "hello user";
    }

    /**
     * Secured endpoint, requires ADMIN role.
     * 
     * @return "hello admin"
     */
    @PreAuthorize("hasRole('ADMIN')") // Method-level security annotation
    @GetMapping("/admin")
    public String adminEndpoint() {
        return "hello admin";
    }
}