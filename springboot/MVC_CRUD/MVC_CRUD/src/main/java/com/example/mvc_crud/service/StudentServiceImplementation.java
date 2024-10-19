package com.example.mvc_crud.service;

import com.example.mvc_crud.model.Students;
import com.example.mvc_crud.repo.Student_Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService {

    private final Student_Repository studentRepository;

    public StudentServiceImplementation(Student_Repository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Students findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Students> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Students student) {
        studentRepository.save(student);
    }

    @Override
    public void update(Students student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(int id) {
        studentRepository.deleteById(id);
    }
}