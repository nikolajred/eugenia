package com.nix.eugenia.controllers;

import com.nix.eugenia.exceptions.ResourceNotFoundException;
import com.nix.eugenia.model.Student;
import com.nix.eugenia.model.UpdateEntity;
import com.nix.eugenia.services.AdministratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AdministratorController {

    private final AdministratorService administratorService;


    @PostMapping(path = "/add/students", consumes = "application/json", produces = "application/json")
    public void addStudent(@RequestBody Student student) {
         administratorService.addStudent(student);
    }


    //TODO
    @PutMapping(path = "/changeteacher/students", consumes = "application/json", produces = "application/json")
    public void changeCurrentTeacher(@Valid @RequestBody UpdateEntity updateEntity ) throws ResourceNotFoundException {
        administratorService.changeCurrentTeacher(updateEntity.getStudentId(),updateEntity.getTeacherId());
    }
    //functional
    @PutMapping(path = "/edit/students", consumes = "application/json", produces = "application/json")
    public void updateStudent(@Valid @RequestBody UpdateEntity updateEntity ) throws ResourceNotFoundException {
        administratorService.updateStudentLessons(updateEntity);
    }

//functional
    @DeleteMapping(path = "/delete/students")
    public void deleteStudent(@Valid @RequestBody UpdateEntity updateEntity) {
        administratorService.deleteStudent(updateEntity.getStudentId());
    }
}


