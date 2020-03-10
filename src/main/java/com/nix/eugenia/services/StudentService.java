package com.nix.eugenia.services;

import com.nix.eugenia.exceptions.ResourceNotFoundException;
import com.nix.eugenia.model.Student;
import com.nix.eugenia.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("I'm sorry but there's not student ", id));
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

}