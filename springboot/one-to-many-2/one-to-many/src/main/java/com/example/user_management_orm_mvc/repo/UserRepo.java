package com.example.user_management_orm_mvc.repo;

import com.example.user_management_orm_mvc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
