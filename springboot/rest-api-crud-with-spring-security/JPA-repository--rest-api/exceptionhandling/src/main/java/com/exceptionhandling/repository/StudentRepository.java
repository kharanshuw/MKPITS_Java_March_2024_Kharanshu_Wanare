package com.exceptionhandling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exceptionhandling.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Integer> {
	
}
