package com.bankapplication.userInformation;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
public class UserService {

	public String getLoggedInUserDetails() {
		  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		  if (authentication != null && authentication.isAuthenticated()) {
	            Object principal = authentication.getPrincipal();
	            if (principal instanceof UserDetails) {
					return ((UserDetails) principal).getUsername();  // Use getUsername() method
	            }
	        }
	        return "Unknown User";
	}
}
