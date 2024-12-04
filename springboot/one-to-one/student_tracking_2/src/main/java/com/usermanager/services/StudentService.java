package com.usermanager.services;

import org.springframework.stereotype.Repository;

import com.usermanager.entity.Student;

@Repository
public interface StudentService {
	public void saveStudent(Student student);
}
