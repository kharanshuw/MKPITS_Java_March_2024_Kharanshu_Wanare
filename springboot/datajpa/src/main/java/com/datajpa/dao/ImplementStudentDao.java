package com.datajpa.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.datajpa.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;



@Repository
public class ImplementStudentDao implements StudentDao {
	
	@Autowired
	public EntityManager entityManager;
	
	public ImplementStudentDao(EntityManager entityManager)
	{
		this.entityManager=entityManager;
	}
	
	@Transactional
	@Override
	public void save(Student student) {
		entityManager.persist(student);		
	}

	@Transactional
	@Override
	public Student fingbyId(int id) {
		return   (Student) entityManager.find(Student.class, id);
	}
	
	@Override
	@Transactional
	public void update(Student student)
	{
		entityManager.merge(student);
	}
	

	@Transactional
	@Override
	public void deletebyId(int id) {
		Student student = entityManager.find(Student.class, id);
 		entityManager.remove(student);
	}
	
	

}
