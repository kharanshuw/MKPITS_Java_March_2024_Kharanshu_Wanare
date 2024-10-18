package com.datajpa.dao;

import com.datajpa.entity.Student;

public interface StudentDao {
	
	void save(Student student);
	
	Student fingbyId(int id);
	
	void deletebyId(int id);

	void update(Student student);

	
	

}
