package com.nix.eugenia.controllers;

import com.nix.eugenia.DTO.StudentDTO;
import com.nix.eugenia.model.Student;

import com.nix.eugenia.services.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentServiceImpl studentServiceImpl;


    @GetMapping("/students/{id}")
    public StudentDTO getStudentById(@PathVariable Long id) {
        return studentServiceImpl.getStudent(id);
    }

    @GetMapping("/students")
    public List<StudentDTO> getAllStudents()

    {
        return studentServiceImpl.getAllStudents();
    }



}

