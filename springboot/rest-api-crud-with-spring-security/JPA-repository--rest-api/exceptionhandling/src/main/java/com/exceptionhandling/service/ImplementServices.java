package com.exceptionhandling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exceptionhandling.entity.Student;

import com.exceptionhandling.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class ImplementServices implements StudentService {

	StudentRepository studentRepository;

	@Autowired
	public ImplementServices(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public void savestudent(Student student) {
		studentRepository.save(student);
	}

	@Override
	public List<Student> findAll() {
		List<Student> list = studentRepository.findAll();
		return list;

	}

	public Student findByIdStudent(int id) {
		Student student = studentRepository.findById(id).orElse(null);

		return student;
	}

	@Override
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}

	@Override
	public void updateStudent(Student student) {
		int id = student.getId();

		Student student2 = findByIdStudent(id);

		if (student2 != null) {
			student2.setFirstname(student.getFirstname());
			student2.setLastname(student.getLastname());
			student2.setId(id);
			studentRepository.save(student2);
		}
	}

}
