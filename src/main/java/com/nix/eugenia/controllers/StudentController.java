package com.nix.eugenia.controllers;

import com.nix.eugenia.model.Student;

import com.nix.eugenia.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents()

    {
        return studentService.getAllStudents();
    }



}

