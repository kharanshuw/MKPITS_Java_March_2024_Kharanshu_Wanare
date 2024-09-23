package com.example.user_management_orm_mvc.service;

import com.example.user_management_orm_mvc.entity.User;
import com.example.user_management_orm_mvc.entity.User_Details;
import com.example.user_management_orm_mvc.repo.UserDetailsRepo;
import com.example.user_management_orm_mvc.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    private final UserDetailsRepo userDetailsRepo;
    private final UserRepo userRepo;

    public UserServiceImplementation(UserDetailsRepo userDetailsRepo, UserRepo userRepo) {
        this.userDetailsRepo = userDetailsRepo;
        this.userRepo = userRepo;
    }

    @Override
    public User save(User user) {
        // Save User_Details first
//        User_Details details = userDetailsRepo.save(user.getUserDetails());
//        user.setUserDetails(details);
        // Save User
        return userRepo.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }
    @Override
    public User findById(int id) {
        return userRepo.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        userRepo.deleteById(id);
    }
}
