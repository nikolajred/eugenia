package com.nix.eugenia.controllers;

import com.nix.eugenia.exceptions.ResourceNotFoundException;
import com.nix.eugenia.model.Student;
import com.nix.eugenia.services.AdministratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AdministratorController {

    private final AdministratorService administratorService;


    @PostMapping(path = "/add/students", consumes = "application/json", produces = "application/json")
    public Student addStudent(@RequestBody Student student) {
        return administratorService.addStudent(student);
    }

/*
    @PutMapping(path = "/edit/students/{id}", consumes = "application/json", produces = "application/json")
    public void changeTeacher(@PathVariable (name ="id") Long studentID, @RequestBody Long teacherID) {
        administratorService.changeCurrentTeacher(studentID, teacherID);
    }
*/
    @PutMapping("/edit/students/{id}")
    public Student updateStudent(@PathVariable(name ="id") Long studentID,
                                                 @Valid @RequestBody Long teacherID) throws ResourceNotFoundException {
      return  administratorService.updateStudent(studentID,teacherID);
    }


    @DeleteMapping(path = "/delete/students/{id}")
    public void deleteStudent(@PathVariable(name="id") Long studentID) {
        administratorService.deleteStudent(studentID);
    }
}

