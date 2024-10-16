package com.exceptionhandling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
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

	public ImplementServices getImeImplementServices() {
		return services;
	}

	@Autowired
	public void setImeImplementServices(ImplementServices imeImplementServices) {
		this.services = imeImplementServices;
	}

	@GetMapping("/students")
	public List<Student> getAllStudents() {
		List<Student> list = services.students();
		return list;
	}

	/*
	 * 
	 * @GetMapping("/student") public Student getStudent(@RequestParam(name = "id")
	 * int id) { Student student = services.student(id); return student; }
	 * 
	 */

	@PostMapping("/students")
	public Student saveStudent(@RequestBody Student student)

	{
		services.savestudent(student);

		return student;
	}

	@DeleteMapping("/deletestudent")
	public void deleteStudent(@RequestParam(name = "id") int id) {
		services.deleteStudent(id);
	}

	@PutMapping("/updateStudent")
	public void updateStudent(@RequestParam(name = "id") int id, @RequestParam(name = "firstname") String fnameString,
			@RequestParam(name = "lastname") String lastnameString) {
		services.updateStudent(id, fnameString, lastnameString);
	}

	@GetMapping("/studentsentity")
	public ResponseEntity<List<Student>> getAllStudentEntity() {
		ResponseEntity<List<Student>> responseEntity = services.studentsEntity();

		return responseEntity;
	}

	@GetMapping("/find")
	public Student getStudentwithException(@RequestParam(name = "id") int id) {
		System.out.println(id);

		Student student = services.student(id);

		if (id >= 10) {
			throw new StudentNotFoundException("id not found");
		}

		return student;
	}
	
	
	/*
this handler is used for specific constructor only
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e) {
		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
		studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		studentErrorResponse.setMessageString(e.getMessage());
		studentErrorResponse.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
	}
*/
}
