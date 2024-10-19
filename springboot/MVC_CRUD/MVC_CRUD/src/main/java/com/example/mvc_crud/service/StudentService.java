package com.example.mvc_crud.service;

import com.example.mvc_crud.model.Students;

import java.util.List;

public interface StudentService {
    Students findById(int id);
    List<Students> findAll();
    void save(Students student);
    void update(Students student);
    void delete(int id);
}
