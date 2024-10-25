package com.myrestdemo.dao;

import java.util.List;
import jakarta.persistence.*;

import org.aspectj.weaver.ast.Not;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.myrestdemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class StudentDaoImplement implements StudentDao {

	@PersistenceContext
	EntityManager entityManager;

	
	/*
	@Override
	public List<Student> students() {
		jakarta.persistence.Query query = entityManager.createQuery("SELECT s.firstname, s.lastname ,s.id FROM Student s");

		return query.getResultList();

	}
	
	*/
	
	public List<Student> students() {
		jakarta.persistence.Query query = entityManager.createQuery("SELECT s.firstname, s.lastname ,s.id FROM Student s");

		return query.getResultList();

	}
	
	
	public ResponseEntity<List<Student>> studentsEntity(){
		Query query = entityManager.createQuery("SELECT s.firstname, s.lastname ,s.id FROM Student s");
		
	List<Student> list	=query.getResultList();
		
		ResponseEntity<List<Student>> responseEntity = new ResponseEntity<>(list,HttpStatus.OK);
		
		return responseEntity;
	}

	@Override
	public Student student(int id) {

		Student student = entityManager.find(Student.class, id);

		return student;
	}

	
	@Override
	public void save(Student student) {
		entityManager.persist(student);
	}

	@Override
	public void deleteStudent(int id) {
		
	Student student	=entityManager.find(Student.class, id);
	entityManager.remove(student);
	
	System.out.println("student data deleted successfully");
	}

	@Override
	public void update(int id,String firstnameString,String lastnameString) {
		Student student = entityManager.find(Student.class, id);
		
		if (student != null){
			student.setFirstname(firstnameString);
			student.setLastname(lastnameString);
			entityManager.merge(student);
			System.out.println("student update successfully");
		}
		else {
			System.out.println("something went wrong in update");
		}
		
	}
	
	
}
