package com.usermanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermanager.entity.Student_details;

public interface StudentsDetailsRepository extends JpaRepository<Student_details, Integer>{

}
