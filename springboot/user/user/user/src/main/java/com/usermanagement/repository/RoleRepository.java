package com.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



import com.usermanagement.entity.Authority;


@Repository
public interface RoleRepository extends JpaRepository<Authority, Integer> {

    Authority findByRole(String role);


}
