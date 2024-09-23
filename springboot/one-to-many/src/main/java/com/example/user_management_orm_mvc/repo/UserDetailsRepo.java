package com.example.user_management_orm_mvc.repo;

import com.example.user_management_orm_mvc.entity.User_Details;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<User_Details, Integer> {
}
