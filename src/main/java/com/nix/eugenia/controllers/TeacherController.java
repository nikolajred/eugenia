package com.nix.eugenia.controllers;

import com.nix.eugenia.model.Student;
import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.repositories.StudentRepository;
import com.nix.eugenia.repositories.TeacherRepository;
import com.nix.eugenia.services.TeacherService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;



    @GetMapping ("/hello/{id}")
    public Teacher getTeacherById(@PathVariable Long id){
        return teacherService.getTeacher(id);
    }



}
