package com.bankapplication.service;

import com.bankapplication.model.Role;
import com.bankapplication.model.User;
import com.bankapplication.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapplication.dto.RequestDto;
import com.bankapplication.repository.RoleRepository;
import com.bankapplication.repository.UserDetailsRepository;
import com.bankapplication.repository.UserRepository;

import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	private UserDetailsRepository userDetailsRepository;

	private RoleRepository roleRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, UserDetailsRepository userDetailsRepository,
			RoleRepository repository) {
		super();
		this.userRepository = userRepository;
		this.userDetailsRepository = userDetailsRepository;
		this.roleRepository = repository;
	}

	@Override
	public RequestDto createuser(RequestDto requestDto) {

		System.out.println(requestDto);

		User user = new User();
		String password = requestDto.getPassword();

		StringBuffer stringBuffer = new StringBuffer(password);

		stringBuffer.insert(0, "{noop}");

		password = stringBuffer.toString();

		System.out.println("new password" + password);

		user.setPassword(password);
		user.setEmail(requestDto.getEmail());

		UserDetails userDetails = new UserDetails();

		userDetails.setFname(requestDto.getFname());

		userDetails.setLname(requestDto.getLname());

		userDetails.setGender(requestDto.getGender());

		userDetails.setPhoneno(requestDto.getPhoneno());

		userDetails.setUser(user);

		user.setUserDetails(userDetails);

		Role role = null;

		try {
			role = roleRepository.findByRolename("ROLE_USER");

			if (role == null) {
				// this block of code will only run if user role does not exist in database
				System.out.println("ROLE_USER not found!");
				return null;
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error finding ROLE_USER: " + e.getMessage());
		}

		HashSet<Role> roles = new HashSet<Role>();

		user.setRole(roles);

		user.getRole().add(role);

		try {
			userRepository.save(user);

			System.out.println("Successfully registered user in user service.");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error saving user: " + e.getMessage());
		}

		return requestDto;
	}

}