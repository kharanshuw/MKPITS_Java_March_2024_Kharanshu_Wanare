package com.exceptionhandling.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.exceptionhandling.entity.Student;

public interface StudentService {

	public List<Student> findAll();
	
//	public Student student(int id);
	
	public void savestudent(Student student);
	
	public void deleteStudent(int id);
	
	public void updateStudent(Student student);
	
//	public ResponseEntity<List<Student>> studentsEntity();
}
