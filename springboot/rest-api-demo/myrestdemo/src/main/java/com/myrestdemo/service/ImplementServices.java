package com.myrestdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.myrestdemo.dao.StudentDao;
import com.myrestdemo.entity.Student;


import jakarta.transaction.Transactional;

@Service
public class ImplementServices implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public List<Student> students() {
		List<Student> list = studentDao.students();
		return list;
	}

	public Student student(int id) {
		Student student = studentDao.student(id);
		return student;
	}

	@Override
	@Transactional
	public void savestudent(Student student) {
	
		studentDao.save(student);
		
		System.out.println("student saved successfully");
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		
		studentDao.deleteStudent(id);
		
		System.out.println("servide delete method called");
		
	}

	@Override
	@Transactional
	public void updateStudent(int id, String firstname, String lastname) {
		studentDao.update(id, firstname, lastname);
		
	}

	@Override
	public ResponseEntity<List<Student>> studentsEntity() {
		ResponseEntity<List<Student>> responseEntity	=studentDao.studentsEntity();
		
		return responseEntity;
	}

}
