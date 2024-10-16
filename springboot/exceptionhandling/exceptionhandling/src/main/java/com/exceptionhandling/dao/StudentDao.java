package com.exceptionhandling.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.exceptionhandling.entity.Student;

public interface StudentDao {

	public List<Student> students();
	
	
	public Student student(int id);
	
	
	public void save(Student student);
	
	public void deleteStudent(int id);
	
	public void update(int id,String firstnameString,String lastnameString);
	
	public ResponseEntity<List<Student>> studentsEntity();
	
	
}
