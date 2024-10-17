package com.bankapplication.getapplicationcontext;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceAppContext {
	
	public String getLoggedInUserEmail() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.isAuthenticated()) {
			Object principal = authentication.getPrincipal();
			if (principal instanceof org.springframework.security.core.userdetails.UserDetails) {
				return ((org.springframework.security.core.userdetails.UserDetails) principal).getUsername(); // Use
																												// getUsername()
																												// method
			}
		}
		return "Unknown User";
	}

}
