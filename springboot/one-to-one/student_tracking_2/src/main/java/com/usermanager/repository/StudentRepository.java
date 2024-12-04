package com.usermanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermanager.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
