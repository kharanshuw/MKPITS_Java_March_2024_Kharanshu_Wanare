package com.exceptionhandling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.exceptionhandling.entity.Student;


@RepositoryRestResource(path = "member")
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
}
