package com.bankapplication.repository;

import com.bankapplication.model.Role;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface RoleRepository extends JpaRepository<Role,Integer> {
	Role findByRolename(String rolename);
}
