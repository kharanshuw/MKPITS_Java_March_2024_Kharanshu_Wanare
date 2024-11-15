package com.bankapplication.service;

import com.bankapplication.dto.ResponseDto;
import com.bankapplication.repository.RoleRepository;
import com.bankapplication.repository.UserDetailsRepository;
import com.bankapplication.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapplication.repository.CityRepository;

import com.bankapplication.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bankapplication.model.UserDetails;

import com.bankapplication.dto.ProfileUpdateDto;

/**
 * AdminServiceImpl class handles all Admin related services
 */
@Service
public class AdminServiceImpl implements AdminService {
    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    EntityManager entityManager;

    // this is userrepositry object
    private UserRepository userRepository;
    // userdetailsrepository object
    private UserDetailsRepository userDetailsRepository;
    // rolerepository object
    private RoleRepository roleRepository;

    private CityRepository cityRepository;

    @Autowired
    public AdminServiceImpl(UserRepository userRepository, UserDetailsRepository userDetailsRepository,
                            RoleRepository roleRepository, CityRepository cityRepository, EntityManager entityManager) {
        this.userRepository = userRepository;
        this.userDetailsRepository = userDetailsRepository;
        this.roleRepository = roleRepository;
        this.cityRepository = cityRepository;
        this.entityManager = entityManager;
    }

    /**
     * Activates a user by setting their active status to true.
     *
     * @param action the action to be performed (not used in this method)
     * @param id     the ID of the user to be activated
     * @return a message indicating the result of the operation
     */
    @Transactional
    public String activateUser(String action, String id) {
        int id1 = Integer.valueOf(id);
        Optional<Users> userOptional = userRepository.findById(id1);
        // check user obj found in database or not
        if (userOptional.isPresent()) {

            Users users = userOptional.get();
            logger.info("user found " + users.toString());
            users.setActive(true);
            // Ensure the user is saved after updating the status
            userRepository.save(users);
            return "Successfully updated status";

        } else {
            logger.error("User with given ID is not available to edit");
            return "User not found";
        }
    }

    /**
     * Helper method to convert a User object to a ResponseDto object.
     *
     * @param users the User object to be converted
     * @return the converted ResponseDto object, or null if the user is not found
     */
    @Transactional
    public ResponseDto convertUserToResponseDto(Users users) {
        if (users == null) {
            System.out.println("user not found");
            logger.error("user not found with id");
            return null;
        } else {
            ResponseDto responseDto = new ResponseDto();
            responseDto.setEmail(users.getEmail());
            responseDto.setFname(users.getUserDetails().getFname());
            responseDto.setLname(users.getUserDetails().getLname());
            responseDto.setId(users.getId());
            responseDto.setGender(users.getUserDetails().getGender());
            responseDto.setPhoneno(users.getUserDetails().getPhoneno());
            responseDto.setRoles(users.getRole());

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
    @Transactional
    public List<String> findRole(String idString) {
        int id = Integer.valueOf(idString);
        List<String> list = null;
        System.out.println("id recived in parameter is :" + id);

        Optional<Users> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {

            logger.info("user found in findrole");
            Users users = userOptional.get();
            // convert user to response dto
            ResponseDto responseDto = convertUserToResponseDto(users);

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
     * @param userid
     * @return a list of role names that the user does not have
     */
    @Transactional
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
     * @param userid   the ID of the user
     * @return a message indicating the result of the operation
     */
    @Transactional
    public String addRoleToUser(String rolename, String userid) {
        int id = Integer.valueOf(userid);
        Optional<Users> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {

            Users users = userOptional.get();
            logger.info("user found " + users.toString());

            Role role = null;

            try {
                // Retrieve role by name
                role = roleRepository.findByRolename(rolename);

                // Check if role exists

                if (role == null) {
                    // this block of code will only run if role does not exist in database
                    // Log error if ROLE_USER is not found
                    logger.error(rolename + " not found! in addroleuser method of adminserviceimpl class");

                    return "role not found in user ";
                }
                // Add role to user and save

                users.addrole(role);
                userRepository.save(users);
                logger.info("Role added successfully in AdminServiceImpl class addRoleToUser method");

                return "Role added successfully";

            } catch (Exception e) {
                logger.error("Error finding given role in database");
                logger.error(e.toString());

            }

            // Ensure the user is saved after updating the status

        } else {
            logger.error(
                    "User with given ID is not available to add role in AdminServiceImpl class addRoleToUser method  ");
            return "user not found";
        }
        return "user not found";
    }

    @Transactional
    public String removeRoleFromUser(String rolename, String userid) {
        int id = Integer.valueOf(userid);

        Optional<Users> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {

            Users users = userOptional.get();

            logger.info("user found inside removeRoleFromUser from adminserviceimpl class " + users.toString());

            Role role = null;

            try {
                // Retrieve role by name from database
                role = roleRepository.findByRolename(rolename);

                // Check if returned role is null
                if (role == null) {
                    // this block of code will only run if role does not exist in database
                    // Log error if ROLE_USER is not found
                    logger.error(rolename + " not found! in removerole method of adminserviceimpl class");

                    return "role not found in user ";
                }
                // Add role to user and save
// Ensure the user is saved after updating the status
                users.removeRole(role);
                userRepository.save(users);
                logger.info("Role removed successfully in AdminServiceImpl class removeRoleFromUser method");

                return "Role removed successfully";

            } catch (Exception e) {
                logger.error("Error finding given role in database");
                logger.error(e.toString());

            }

        } else {
            logger.error(
                    "User with given ID is not available to add role in AdminServiceImpl class removeRoleFromUser method  ");
            return "user not found";
        }
        return "user not found";
    }

//    @Transactional()
//    public Users updateAdmin(ProfileUpdateDto profileUpdateDto) {
//
//        System.out.println("updating admin user :" + profileUpdateDto);
//
//        Users users = null;
//
//        try {
//            Integer cityid = profileUpdateDto.getCityid();
//
//            System.out.println(cityid);
//
//            String email = profileUpdateDto.getEmail();
//            System.out.println(email);
//
//            String fname = profileUpdateDto.getFname();
//
//            String lname = profileUpdateDto.getLname();
//
//            String gender = profileUpdateDto.getGender();
//
//            String phoneno = profileUpdateDto.getPhoneno();
//
//            System.out.println(fname);
//
//            System.out.println(lname);
//            System.out.println(gender);
//            System.out.println(phoneno);
//
//            City city = cityRepository.findByCityId(cityid);
//
//            System.out.println("city found with this id : " + city);
//
//            int id = userRepository.findIdByEmail(email);
//
//            System.out.println("id find by userRepository.findIdByEmail(email) in adminserviceimpl is   " + id);
//
//            Optional<Users> userOptional = userRepository.findById(id);
//
//            if (userOptional.isPresent()) {
//                users = userOptional.get();
//                System.out.println("user found by userRepository.findById(id) in admincontroller updateadmin method  "
//                        + users.getId());
//                UserDetails userDetails = users.getUserDetails();
//
//                userDetails.setFname(fname);
//                userDetails.setLname(lname);
//                userDetails.setPhoneno(phoneno);
//                userDetails.setGender(gender);
//
//                city.addUserDetails(userDetails);
//
//
//                userDetails.setCity(city);
//                users.setUserDetails(userDetails);
//
//                System.out.println("user updated successfully");
//
//                entityManager.flush();
//
//                
//            }
//
//        } catch (Exception e) {
//            System.out.println("exception occured at updateadmin method of adminservice class ");
//            throw new RuntimeException(e);
//        }
//
//
//        return userRepository.save(users);
//
//    }

    @Transactional
    public Users getUserById(int id) {
        Optional<Users> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new RuntimeException("user with given id not found ");
        }
    }

    @Transactional
    public int getIdByEmail(String email) {
        int id = userRepository.findIdByEmail(email);
        return id;
    }

    public Users getUserByEmail(String email) {
        Users users = userRepository.findUserByEmail(email);
        if (users == null) {
            logger.error("user not found by email");
            throw new RuntimeException("user not found by email ");

        } else {
            return users;
        }


    }
}
