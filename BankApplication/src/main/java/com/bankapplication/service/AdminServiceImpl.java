package com.bankapplication.service;

import com.bankapplication.controller.UserController;
import com.bankapplication.repository.RoleRepository;
import com.bankapplication.repository.UserDetailsRepository;
import com.bankapplication.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapplication.model.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService
{

    // Logger for this class
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    // Repositories for database operations

    private UserRepository userRepository;

    private UserDetailsRepository userDetailsRepository;

    private RoleRepository roleRepository;

    @Autowired
    public AdminServiceImpl(UserRepository userRepository, UserDetailsRepository userDetailsRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userDetailsRepository = userDetailsRepository;
        this.roleRepository = roleRepository;
    }
    
    public String activateUser(String action,String id)
    {
            int id1=Integer.valueOf(id);
           Optional<User> userOptional  =userRepository.findById(id1);
           //check user obj found in database or not
           if (userOptional.isPresent()){
               
                   User user=userOptional.get();
                   logger.info("user found "+user.toString());
                   user.setActive(true);
                   // Ensure the user is saved after updating the status
                   userRepository.save(user);
                   return "Successfully updated status";
               
           }
           else {
               logger.error("User with given ID is not available to edit");
               return "User not found";
           }
    }
}
