package com.usermanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usermanager.entity.Student;
import com.usermanager.entity.Student_details;
import com.usermanager.repository.StudentRepository;
import com.usermanager.repository.StudentsDetailsRepository;

import jakarta.transaction.Transactional;

@Repository
public class StudentServiceIMPL implements StudentService {

	private StudentRepository studentRepository;
	
	private StudentsDetailsRepository studentsDetailsRepository;
	
	
	@Autowired
	public StudentServiceIMPL(StudentRepository studentRepository,StudentsDetailsRepository studentsDetailsRepository) {
		super();
		this.studentRepository = studentRepository;
		this.studentsDetailsRepository = studentsDetailsRepository;
	}

	//save student details
	@Transactional
	public void saveStudentDetails(Student_details student_details)
	{
		studentsDetailsRepository.save(student_details);
		System.out.println(student_details);
		System.out.println("successfully inserted");
	}

	@Override
	public void saveStudent(Student student) {
	/*	
		//get student detail from student obj
		Student_details student_details =student.getStudent_details();
		
		//save student details first 
		saveStudentDetails(student_details);
		*/
		//save student 
		studentRepository.save(student);
		
		
		
		System.out.println("successfully inserted");
	}
	
	
	public List<Student> findallstudnetList()
	{
		List<Student> list =studentRepository.findAll();
		return list;
	}
	
	public Student findbyidStudent(int id)
	{
		return studentRepository.findById(id).orElse(null);
	}
	
	public void deletestudent(int id)
	{
		Student student=findbyidStudent(id);
		studentRepository.deleteById(id);
		System.out.println(student);
	}
	
	
	public void updatestudent(Student student2)
	{
		int id=student2.getId();
		
		Student student=findbyidStudent(id);
		
		if (student != null) {
			student.setFirstname(student2.getFirstname());
			student.setLastnameString(student2.getLastnameString());
			student.setStudent_details(student2.getStudent_details());
			studentRepository.save(student);
		}
	}
	

}
