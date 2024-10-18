package com.datajpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.datajpa.dao.ImplementStudentDao;
import com.datajpa.dao.StudentDao;
import com.datajpa.entity.Student;

@SpringBootApplication
public class DatajpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatajpaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner (ImplementStudentDao studentDao)
	{
		return runner->{
			
			//studentDao.save(new Student("kharanshu","wanare"));
		/*
	
		Student student	=studentDao.fingbyId(2);
		System.out.println(student);
		};
		
		*/
			
			studentUpdate(studentDao, 2) ;
		};
	}
	
	
	public void studentUpdate(ImplementStudentDao studentDao,int id)
	{
		Student student= studentDao.fingbyId(id)		;
		if (student!=null) {
			student.setFirstName("a");
			student.setLastName("b");
			studentDao.update(student);
			System.out.println("student update successfully");
		}
	}

}
