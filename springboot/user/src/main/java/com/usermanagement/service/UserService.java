package com.usermanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanagement.repository.*;

import com.usermanagement.entity.*;

@Service
public class UserService {
	
	private UserRepository userRepository;
	
	private RoleRepository roleRepository;

	@Autowired
	public UserService(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	
	
	public void registerUser(User user) {
	    // Save userdetails
	    UserDetail userDetail = user.getUserDetail();
	    userDetail.setUser(user);
	    
	    
	    
	    // Add authorities (roles) to user
	    List<Authority> authorities = new ArrayList<>();
	    // ROLEREPOSITORY have a method to get roles by name
	    Authority authority = roleRepository.findByRole("ROLE_USER");
	    
	   
	    authorities.add(authority);
	    
	    //set authority of user
	    user.setAuthorities(authorities);
	    
	    //save user 
	    userRepository.save(user);
	}

	
}