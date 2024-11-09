package com.bankapplication.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import jakarta.transaction.Transactional;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;

import org.springframework.stereotype.Service;

import com.bankapplication.repository.*;

import com.bankapplication.model.UserDetails;

import com.bankapplication.dto.*;

import com.bankapplication.model.*;

// This class is a Spring Service that implements user-related operations

@Service
public class UserServiceImpl implements UserService {

	// Logger for this class
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

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

	/**
	 * Creates a new user based on the provided RequestDto.
	 *
	 * @param requestDto The request DTO containing user details.
	 * @return The original request DTO (may be null on error).
	 * @throws IllegalArgumentException if password is empty or null.
	 */
	@Override
	@Transactional
	public RequestDto createuser(RequestDto requestDto) {

		// Log the incoming request data
		logger.info(requestDto.toString());

		// Create a new User entity
		User user = new User();
		String password = requestDto.getPassword();

		// Prepare the password by adding "{noop}" prefix (for NoOpPasswordEncoder)
		StringBuffer stringBuffer = new StringBuffer(password);

		stringBuffer.insert(0, "{noop}");

		password = stringBuffer.toString();

		logger.info("new password" + password);

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
				// Log error if ROLE_USER is not found
				logger.error("ROLE_USER not found!");

				return null;
			}
		} catch (Exception e) {
			// Log any errors in finding the role

			logger.error("Error finding ROLE_USER: " + e.getMessage());

		}
		// Add the ROLE_USER to the user
		user.addrole(role);
		try {
			// Save the user to the database
			userRepository.save(user);
			logger.info("Successfully registered user in user service.");
		} catch (Exception e) {
			// Log any errors in saving the user
			logger.error("Error saving user: " + e.getMessage());
		}
		// Return the original request DTO
		return requestDto;
	}

	/**
	 * Retrieves the logged-in user's details based on the provided email.
	 *
	 * @param email The email address of the logged-in user.
	 * @return The ResponseDto containing the user's details, or null if not found.
	 */
	public ResponseDto getLoggedInUserDetails(String email) {

		// Log received email

		logger.info("Email received at getLoggedInUserDetails  method of UserServiceImpl class  : {}", email);

		// Find logged in user details by email

		User user = userRepository.findUserByEmail(email);
		if (user == null) {
			logger.info("Logged in user not found");
			return null;
		}

		// Log found user details

		logger.info("Found user: {}", user.toString());

		// Find user by ID

		ResponseDto responseDto = createResponseDto(user);

		return responseDto;
	}

	/**
	 * Creates a ResponseDto object from a given User object.
	 *
	 * This method copies relevant fields from the User object to the ResponseDto
	 * object.
	 *
	 * @param user The User object to be converted.
	 * @return The created ResponseDto object.
	 */
	private ResponseDto createResponseDto(User user) {
		ResponseDto responseDto = new ResponseDto();

		responseDto.setId(user.getId());
		logger.debug("Setting ID: {}", user.getId());

		responseDto.setEmail(user.getEmail());
		logger.debug("Setting Email: {}", user.getEmail());

		responseDto.setFname(user.getUserDetails().getFname());
		logger.debug("Setting First Name: {}", user.getUserDetails().getFname());

		responseDto.setLname(user.getUserDetails().getLname());
		logger.debug("Setting Last Name: {}", user.getUserDetails().getLname());

		responseDto.setGender(user.getUserDetails().getGender());
		logger.debug("Setting Gender: {}", user.getUserDetails().getGender());

		responseDto.setPhoneno(user.getUserDetails().getPhoneno());
		logger.debug("Setting Phone Number: {}", user.getUserDetails().getPhoneno());

		responseDto.setRoles(user.getRole());
		logger.debug("Setting Roles: {}", user.getRole());

		logger.debug("ResponseDto created: {}", responseDto);
		return responseDto;
	}

	/**
	 * Method to find all users and convert them into ResponseDto objects.
	 * 
	 * @return a list of ResponseDto objects representing the users.
	 */

	@Override
	public List<ResponseDto> findAllUser() {
		// Retrieve all users from the repository

		List<User> users = userRepository.findAll();

		// Check if the users list is empty

		if (users.isEmpty()) {
			// Log an error if no users are found
			logger.error("Users list in findAllUser method of UserServiceImpl class is empty");
			return Collections.emptyList();

		}

		else {
			// Log information indicating users were found
			logger.info("List of users found in findAllUser method of UserServiceImpl class");
			// Create a list to hold the ResponseDto objects

			List<ResponseDto> list = new ArrayList<>();
			// Iterate through each user and convert to ResponseDto

			for (User u : users) {

				// Create a ResponseDto from the User object

				ResponseDto responseDto = createResponseDto(u);
				// Log information indicating a response entity was created

				logger.info("response entity created ");
				// Add the ResponseDto to the list

				list.add(responseDto);

			}
			// Return the list of ResponseDto objects

			return list;

		}

	}

	/**
	 * Retrieves a list of inactive users and converts them to a list of ResponseDto
	 * objects.
	 *
	 * @return A list of ResponseDto objects representing inactive users.
	 */
	@Override
	public List<ResponseDto> findallInactiveUser() {

		List<User> inactiveUsers = userRepository.findInactiveUsers();
		logger.debug("Found {} inactive users", inactiveUsers.size());

		// list to store inactive store in dto obj
		List<ResponseDto> list1 = new ArrayList<>();

		for (User u : inactiveUsers) {
			ResponseDto responseDto = new ResponseDto();
			responseDto.setEmail(u.getEmail());
			responseDto.setId(u.getId());
			list1.add(responseDto);
			logger.debug("Added ResponseDto for user: {}", u.getId());

		}
		logger.debug("Returning {} inactive user ResponseDtos", list1.size());

		return list1;
	}

	/**
	 * Converts a ResponseDto object to a ProfileUpdateDto object.
	 *
	 * This method copies the relevant fields from the ResponseDto to the
	 * ProfileUpdateDto.
	 *
//	 * @param responseDto The ResponseDto object to be converted.
	 * @return The converted ProfileUpdateDto object.
	 */
	public ProfileUpdateDto convertToProfileUpdate(User user) {
		// Check for null user
		if (user == null) {
			return null;
		}

		ProfileUpdateDto profileUpdateDto = new ProfileUpdateDto();

		profileUpdateDto.setEmail(user.getEmail());
		
		profileUpdateDto.setId(user.getId());
		
		profileUpdateDto.setFname(user.getUserDetails().getFname());
		profileUpdateDto.setLname(user.getUserDetails().getLname());
		profileUpdateDto.setGender(user.getUserDetails().getGender());
		profileUpdateDto.setPhoneno(user.getUserDetails().getPhoneno());

		return profileUpdateDto;

	}

	public User getUserByEmail(String email) {
		User user = null;

		user = userRepository.findUserByEmail(email);

		return user;
	}

}