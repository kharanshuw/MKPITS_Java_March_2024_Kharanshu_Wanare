package com.example.mvc_crud.repo;

import com.example.mvc_crud.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Student_Repository extends JpaRepository<Students,Integer> {
}
