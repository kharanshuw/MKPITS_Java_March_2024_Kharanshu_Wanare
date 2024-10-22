package com.bankapplication.service;

import com.bankapplication.controller.UserController;
import com.bankapplication.dto.ResponseDto;
import com.bankapplication.repository.RoleRepository;
import com.bankapplication.repository.UserDetailsRepository;
import com.bankapplication.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapplication.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* AdminServiceImpl class handles all Admin related services
* 
* */
@Service
public class AdminServiceImpl implements AdminService {
    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    //this is userrepositry object
    private UserRepository userRepository;
//userdetailsrepository object
    private UserDetailsRepository userDetailsRepository;
//rolerepository object
    private RoleRepository roleRepository;

    @Autowired
    public AdminServiceImpl(UserRepository userRepository, UserDetailsRepository userDetailsRepository,
                            RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userDetailsRepository = userDetailsRepository;
        this.roleRepository = roleRepository;
    }


    /**
     * Activates a user by setting their active status to true.
     *
     * @param action the action to be performed (not used in this method)
     * @param id the ID of the user to be activated
     * @return a message indicating the result of the operation
     */
    public String activateUser(String action, String id) {
        int id1 = Integer.valueOf(id);
        Optional<User> userOptional = userRepository.findById(id1);
        // check user obj found in database or not
        if (userOptional.isPresent()) {

            User user = userOptional.get();
            logger.info("user found " + user.toString());
            user.setActive(true);
            // Ensure the user is saved after updating the status
            userRepository.save(user);
            return "Successfully updated status";

        } else {
            logger.error("User with given ID is not available to edit");
            return "User not found";
        }
    }

    /**
     * Helper method to convert a User object to a ResponseDto object.
     *
     * @param user the User object to be converted
     * @return the converted ResponseDto object, or null if the user is not found
     */
    public ResponseDto convertUserToResponseDto(User user) {
        if (user == null) {
            System.out.println("user not found");
            logger.error("user not found with id");
            return null;
        } else {
            ResponseDto responseDto = new ResponseDto();
            responseDto.setEmail(user.getEmail());
            responseDto.setFname(user.getUserDetails().getFname());
            responseDto.setLname(user.getUserDetails().getLname());
            responseDto.setId(user.getId());
            responseDto.setGender(user.getUserDetails().getGender());
            responseDto.setPhoneno(user.getUserDetails().getPhoneno());
            responseDto.setRoles(user.getRole());

            logger.info("user successfully convertd to response dto in adminserviceimpl");
            return responseDto;
        }

    }

    /**
     * This method returns a list of roles that the user already has.
     *
     * @param idString the ID of the user
     * @return a list of role names that the user has
     */
    public List<String> findRole(String idString) {
        int id = Integer.valueOf(idString);
        List<String> list = null;
        System.out.println("id recived from user" + id);

        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {

            logger.info("user found in findrole");
            User user = userOptional.get();
            // convert user to response dto
            ResponseDto responseDto = convertUserToResponseDto(user);

            // response dto method getrolestring returns arraylist<string> of roles assigned
            // to user
            list = responseDto.getrolestring();
            return list;
        } else {
            // if roles not assigned to user
            logger.error("list of user roles is null ");
            return list;
        }
    }

    /**
     * This method finds all roles that a user does not have and returns them in a
     * list.
     *
     * @param idString the ID of the user
     * @return a list of role names that the user does not have
     */
    public List<String> findUnassignedRoles(String userid) {

        // This is the list of roles which the user already has

        List<String> userRoles = findRole(userid);

        // This list contains all the roles available in the database
        List<String> allRoles = roleRepository.findAllRoleName();

        // Empty list to store roles which are not assigned to the user
        List<String> unassignedRoles = new ArrayList<>();

        // Log and print all available roles in the database
        logger.info("All the roles available in the database are:");

        System.out.println("all the roles available in database are ");

        // print list2 which contains all available role in database
        for (String s : allRoles) {
            System.out.println(s);

            logger.info(s);
        }

        // Find roles not assigned to the user and add them to list3
        for (String s : allRoles) {
            if (!userRoles.contains(s)) {

                // Add only those roles which the user does not have
                logger.info("add only those role which user does not have");
                unassignedRoles.add(s);
            }
        }

        // Log and print roles that the user does not have
        logger.info("Roles that the user does not have:");
        for (String string : unassignedRoles) {
            System.out.println(string);
        }

        // Return the list of roles that the user does not have
        return unassignedRoles;

    }

    /**
     * Adds a role to a user.
     *
     * @param rolename the name of the role to be added
     * @param userid the ID of the user
     * @return a message indicating the result of the operation
     */
    public String addRoleToUser(String rolename, String userid) {
        int id = Integer.valueOf(userid);
        Optional<User> userOptional = userRepository.findById(id);
		if (userOptional.isPresent()) {

			User user = userOptional.get();
			logger.info("user found " + user.toString());
			
            Role role = null;
            
            try{
                // Retrieve role by name
                role= roleRepository.findByRolename(rolename);

                // Check if role exists

                if (role==null)
                {
                    // this block of code will only run if  role does not exist in database
                    // Log error if ROLE_USER is not found
                    logger.error(rolename+" not found! in addroleuser method of adminserviceimpl class");

                    return "role not found in user ";
                }
                // Add role to user and save

                user.addrole(role);
                userRepository.save(user);
                logger.info("Role added successfully in AdminServiceImpl class addRoleToUser method");

                return "Role added successfully";

            }
            catch (Exception e)
            {
                logger.error("Error finding given role in database");
                logger.error(e.toString());


            }
			
			// Ensure the user is saved after updating the status
			
			

		} else {
			logger.error("User with given ID is not available to add role in AdminServiceImpl class addRoleToUser method  ");
		    return  "user not found";	
		}
        return  "user not found";
    }
    
}
