package com.bankapplication.service;

import com.bankapplication.controller.UserController;
import com.bankapplication.dto.LoggesInUserDetails;
import com.bankapplication.model.Role;
import com.bankapplication.model.User;
import com.bankapplication.model.UserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.bankapplication.dto.RequestDto;
import com.bankapplication.dto.ResponseDto;
import com.bankapplication.repository.RoleRepository;
import com.bankapplication.repository.UserDetailsRepository;
import com.bankapplication.repository.UserRepository;



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

		logger.info("Email received at getuserdetail method: {}", email);

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

			System.out.println("user not found in getLoggedInUserDetails method");
			logger.error("user not found in getLoggedInUserDetails method");
			return null;
		} else {
			
		    // Log if user is found

			System.out.println("user found in getLoggedInUserDetails method");
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
		responseDto.setGender(user.getUserDetails().getGender());
		responseDto.setLname(user.getUserDetails().getLname());
		responseDto.setPhoneno(user.getUserDetails().getPhoneno());
		responseDto.setRoles(user.getRole());
		return responseDto;
	}

	@Override
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