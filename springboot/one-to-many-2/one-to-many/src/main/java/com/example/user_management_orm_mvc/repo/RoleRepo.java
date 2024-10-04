package com.example.user_management_orm_mvc.repo;

import com.example.user_management_orm_mvc.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
}
