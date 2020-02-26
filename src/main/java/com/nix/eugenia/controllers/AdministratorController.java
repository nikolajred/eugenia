package com.nix.eugenia.controllers;

import com.nix.eugenia.exceptions.StudentNotFoundException;
import com.nix.eugenia.model.Student;
import com.nix.eugenia.repositories.StudentRepository;
import com.nix.eugenia.repositories.TeacherRepository;
import com.nix.eugenia.services.AdministratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequiredArgsConstructor
public class AdministratorController {

    private  final AdministratorService administratorService;



    @PostMapping(path = "/add/students", consumes = "application/json", produces = "application/json")
    public void addStudent(@RequestBody Student student) {
       administratorService.addStudent(student);
    }



    @PutMapping(path = "/edit/students", produces = "application/json")
    public void addStudent(@RequestBody Long studentID, Long teacherID) {
        administratorService.changeCurrentTeacher(studentID,teacherID);
    }

    @DeleteMapping(path = "/delete/students/{id}", produces = "application/json")
    public void deleteStudent(@PathVariable Long studentID) {
        administratorService.deleteStudent(studentID);
    }
}

