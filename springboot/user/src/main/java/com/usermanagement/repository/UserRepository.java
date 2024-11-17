package com.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermanagement.entity.*;

public interface UserRepository extends JpaRepository<User, Integer> {

}
