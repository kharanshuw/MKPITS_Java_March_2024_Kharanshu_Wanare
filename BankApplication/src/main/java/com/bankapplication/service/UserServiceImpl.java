package com.bankapplication.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;

import org.springframework.stereotype.Service;

import com.bankapplication.repository.*;

import com.bankapplication.model.UserDetails;

import com.bankapplication.controller.UserController;

import com.bankapplication.dto.*;

import com.bankapplication.model.*;

// This class is a Spring Service that implements user-related operations

@Service
public class UserServiceImpl implements UserService {

	// Logger for this class
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	// Repositories for database operations

	private UserRepository userRepository;

	private UserDetailsRepository userDetailsRepository;

	private RoleRepository roleRepository;

	// Constructor for dependency injection

	@Autowired
	public UserServiceImpl(UserRepository userRepository, UserDetailsRepository userDetailsRepository,
			RoleRepository repository) {
		super();
		this.userRepository = userRepository;
		this.userDetailsRepository = userDetailsRepository;
		this.roleRepository = repository;
	}

	// Method to create a new user

	@Override
	public RequestDto createuser(RequestDto requestDto) {

		// Log the incoming request data

		System.out.println(requestDto.toString());

		logger.info(requestDto.toString());

		// Create a new User entity
		User user = new User();
		String password = requestDto.getPassword();

		// Prepare the password by adding "{noop}" prefix (for NoOpPasswordEncoder)
		StringBuffer stringBuffer = new StringBuffer(password);

		stringBuffer.insert(0, "{noop}");

		password = stringBuffer.toString();

		System.out.println("new password" + password);

		// Set user properties
		user.setPassword(password);
		user.setEmail(requestDto.getEmail());

		// Create and set UserDetails entity
		UserDetails userDetails = new UserDetails();

		userDetails.setFname(requestDto.getFname());

		userDetails.setLname(requestDto.getLname());

		userDetails.setGender(requestDto.getGender());

		userDetails.setPhoneno(requestDto.getPhoneno());

		userDetails.setUser(user);

		// Establish bidirectional relationship
		user.setUserDetails(userDetails);

		// Find the "ROLE_USER" role
		Role role = null;

		try {
			role = roleRepository.findByRolename("ROLE_USER");

			if (role == null) {
				// this block of code will only run if user role does not exist in database
				System.out.println("ROLE_USER not found!");

				// Log error if ROLE_USER is not found
				logger.error("ROLE_USER not found!");

				return null;
			}
		} catch (Exception e) {
			// Log any errors in finding the role
			System.out.println(e);
			logger.error("Error finding ROLE_USER: " + e.getMessage());
			System.out.println("Error finding ROLE_USER: " + e.getMessage());
		}

		// Add the ROLE_USER to the user
		user.addrole(role);

		try {
			// Save the user to the database

			userRepository.save(user);

			System.out.println("Successfully registered user in user service.");

			logger.info("Successfully registered user in user service.");
		} catch (Exception e) {

			// Log any errors in saving the user

			System.out.println("Error saving user: " + e.getMessage());
			logger.error("Error saving user: " + e.getMessage());
		}

		// Return the original request DTO
		return requestDto;
	}

	// Method to get user details who is logged in
	public ResponseDto getLoggedInUserDetails(String email) {

		// Log received email

		logger.info("Email received at getLoggedInUserDetails  method of UserServiceImpl class  : {}", email);

		// Find logged in user details by email

		LoggesInUserDetails loggesInUserDetails = userRepository.findUserRoleDetailsByEmail(email);
		if (loggesInUserDetails == null) {
			logger.info("Logged in user not found");
			return null;
		}

		// Log found user details

		logger.info("Found user: {}", loggesInUserDetails);

		// Find user by ID

		User user = userRepository.findById(loggesInUserDetails.getId()).orElse(null);

		if (user == null) {

			// Log if user is not found

			logger.error("user not found in getLoggedInUserDetails method");
			return null;
		} else {
			// Log if user is found

			logger.info("user found in getLoggedInUserDetails method");

			// Create and return ResponseDto with user details

			ResponseDto responseDto = createResponseDto(user);

			return responseDto;
		}

	}

	// Helper method to create ResponseDto from User entity

	private ResponseDto createResponseDto(User user) {
		ResponseDto responseDto = new ResponseDto();

		responseDto.setId(user.getId());

		responseDto.setEmail(user.getEmail());

		responseDto.setFname(user.getUserDetails().getFname());

		responseDto.setLname(user.getUserDetails().getLname());

		responseDto.setGender(user.getUserDetails().getGender());

		responseDto.setPhoneno(user.getUserDetails().getPhoneno());

		responseDto.setRoles(user.getRole());

		return responseDto;
	}

	@Override
	public List<ResponseDto> findAllUser() {

		List<User> users = userRepository.findAll();

		if (users.isEmpty()) {
			System.out.println("Users list in findAllUser method of UserServiceImpl class is empty");
			logger.error("Users list in findAllUser method of UserServiceImpl class is empty");
			return Collections.emptyList();
		}

		else {
			logger.info("List of users found in findAllUser method of UserServiceImpl class");
			System.out.println("list of user printing");

			List<ResponseDto> list = new ArrayList<>();
			for (User u : users) {
				ResponseDto responseDto = createResponseDto(u);
				System.out.println(responseDto);
				logger.info("response entity created ");
				list.add(responseDto);

			}

			return list;

		}

	}

}