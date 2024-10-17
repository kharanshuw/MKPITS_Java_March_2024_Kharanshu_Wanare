package com.exceptionhandling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exceptionhandling.customexception.StudentErrorResponse;
import com.exceptionhandling.customexception.StudentNotFoundException;
import com.exceptionhandling.entity.Student;
import com.exceptionhandling.service.*;

@RestController
@RequestMapping(value = "/api", method = RequestMethod.GET)
public class MyController {

	ImplementServices services;

	@Autowired
	public MyController(ImplementServices services) {
		super();
		this.services = services;
	}

	@PostMapping("/student")
	public void saveStudent(@RequestBody Student student) {
		services.savestudent(student);
		System.out.println("student saved successfully");
	}

	@GetMapping("/students")
	public List<Student> findAll() {
	List<Student> list	=services.findAll();
	return list;
		}
	
	
	
	@GetMapping("/getstudent/{id}")
	public Student findByIdStudent(@PathVariable int id) {
	Student student	=services.findByIdStudent(id);
		
		return student;
	}
	
	@DeleteMapping("/student/{id}")
	public void deleteStudent(@PathVariable int id) {
		services.deleteStudent(id);
		System.out.println("delete student");
	}
	
	
	@PutMapping("/updatestudents")
	public void putMethodName( @RequestBody Student entity) {
		services.updateStudent(entity);
		System.out.println("update called");
	}

	/*
	 * @GetMapping("/find") public Student
	 * getStudentwithException(@RequestParam(name = "id") int id) {
	 * System.out.println(id);
	 * 
	 * Student student = services.student(id);
	 * 
	 * if (id >= 10) { throw new StudentNotFoundException("id not found"); }
	 * 
	 * return student; }
	 */

	/*
	 * this handler is used for specific constructor only
	 * 
	 * @ExceptionHandler public ResponseEntity<StudentErrorResponse>
	 * handleException(StudentNotFoundException e) { StudentErrorResponse
	 * studentErrorResponse = new StudentErrorResponse();
	 * studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
	 * studentErrorResponse.setMessageString(e.getMessage());
	 * studentErrorResponse.setTimestamp(System.currentTimeMillis());
	 * 
	 * return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND); }
	 */
}
