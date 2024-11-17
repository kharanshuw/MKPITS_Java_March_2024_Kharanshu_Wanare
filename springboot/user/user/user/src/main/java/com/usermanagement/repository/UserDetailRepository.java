package com.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermanagement.entity.*;

public interface UserDetailRepository extends JpaRepository<UserDetail, Integer> {

}
