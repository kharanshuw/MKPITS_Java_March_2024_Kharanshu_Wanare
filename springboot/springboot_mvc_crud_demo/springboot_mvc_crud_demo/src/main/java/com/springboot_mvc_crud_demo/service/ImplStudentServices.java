package com.springboot_mvc_crud_demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.TinyBitSet;
import org.springframework.stereotype.Service;

import com.springboot_mvc_crud_demo.entity.Student;
import com.springboot_mvc_crud_demo.repository.StudentRepository;


@Service
public class ImplStudentServices implements StudentService {

	StudentRepository studentRepository;

	@Autowired
	public ImplStudentServices(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> findAll() {
		List<Student> list	=studentRepository.findAll();
		return list;
	}

	@Override
	public void addStudent(Student student) {
		studentRepository.save(student);
		
	}

	@Override
	public void updateStudent(Student student) {
		Student student2 = findById(student.getId());
		if (student2 !=null) {
			student2.setFirstname(student.getFirstname());
			student2.setLastname(student2.getLastname());
			student2.setId(student.getId());
			studentRepository.save(student2);
		}
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		Student student = findById(id);
		studentRepository.deleteById(id);
		System.out.println(student);
	}

	@Override
	public Student findById(int id) {
		
	return	studentRepository.findById(id).orElse(null);
		
		
		}

}
