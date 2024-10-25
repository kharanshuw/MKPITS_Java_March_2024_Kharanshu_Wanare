package com.myrestdemo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.myrestdemo.entity.Student;

public interface StudentService {

	public List<Student> students();
	
	public Student student(int id);
	
	public void savestudent(Student student);
	
	public void deleteStudent(int id);
	
	public void updateStudent(int id,String firstname,String lastname);
	
	public ResponseEntity<List<Student>> studentsEntity();
}
