package com.springboot_mvc_crud_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot_mvc_crud_demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
