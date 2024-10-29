package com.springboot2.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot2.entity.Student;

@RestController
@RequestMapping(value = "/student", method = RequestMethod.GET)

public class MyController {

	List<Student> list;
	
	

	public MyController() {
		list = new ArrayList<>();
	}
	
	
	

	@GetMapping("/")
	public String printname() {

		return "hello ";
	}

	
	
	@GetMapping("/add")
	public Student addStudent(@RequestParam(name = "id") String idString,
			@RequestParam(name = "name") String nameString) {
		Student student = new Student(idString, nameString);
		list.add(student);
		return student;
	}

	
	
	@GetMapping("/student")
	public Student getStudent() {
		System.out.println("null");
		return null;
	}

	
	/*
	@GetMapping("/student/{id}")
	public Student getStudentWithRollno(@PathVariable String id) {
		Iterator iterator = list.iterator();

		while (iterator.hasNext()) {
			Student student = (Student) iterator.next();
			if (student.getRollnoString().equals(id)) {
				return student;
			}
		}
		return null;

	}
	
	*/
	
	@GetMapping("/student/{id}")
	public Student getStudentWithRollno(@PathVariable String id) {
		
		return list.stream().filter(
				x->{
				return x.getRollnoString().equals(id);
				}
				).findAny().get();
				
	}
	

	@GetMapping("/liststudent")
	public List<Student> getListOfStudent() {
		return list;
	}
	
	

}
