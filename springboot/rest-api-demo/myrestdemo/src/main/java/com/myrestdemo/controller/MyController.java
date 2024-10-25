package com.myrestdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myrestdemo.entity.Student;
import com.myrestdemo.service.ImplementServices;

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

	@GetMapping("/getstudents")
	public List<Student> getAllStudents() {
		List<Student> list = services.students();
		return list;
	}

	@GetMapping("/student")
	public Student getStudent(@RequestParam(name = "id") int id) {
		Student student = services.student(id);
		return student;
	}
	
	
	
	@PostMapping("/poststudents")
	public Student saveStudent(@RequestBody Student student)
	
	{
		services.savestudent(student);
		
		return student;
	}
	
	
	@DeleteMapping("/deletestudent")
	public void deleteStudent(@RequestParam(name = "id") int id)
	{
		services.deleteStudent(id);
	}
	
	
	@PutMapping("/updateStudent")
	public void updateStudent(@RequestParam(name = "id") int id , 
							@RequestParam(name = "firstname") String fnameString,
							@RequestParam(name = "lastname") String lastnameString)
	{
		services.updateStudent(id, fnameString, lastnameString);
	}
	
	
	
	@GetMapping("/studentsentity")
	public ResponseEntity<List<Student>> getAllStudentEntity() {
		ResponseEntity<List<Student>> responseEntity = services.studentsEntity();
		
		return responseEntity;
	}
}
