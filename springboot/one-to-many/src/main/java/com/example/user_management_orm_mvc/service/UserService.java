package com.example.user_management_orm_mvc.service;

import com.example.user_management_orm_mvc.entity.User;
import java.util.List;

public interface UserService {
    User save(User user);
    List<User> findAll();
    User findById(int id);
    void deleteById(int id);
//logina nd logout
}
