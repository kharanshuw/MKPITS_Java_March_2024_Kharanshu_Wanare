package com.springboot_mvc_crud_demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot_mvc_crud_demo.entity.Student;


@Service
public interface StudentService {
	
	public List<Student> findAll();
	
	public void addStudent(Student student);
	
	public void updateStudent(Student student);
	
	public void deleteStudent(int id);
	
	public Student findById(int id);
	
}
