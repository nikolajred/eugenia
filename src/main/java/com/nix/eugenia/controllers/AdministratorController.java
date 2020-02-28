package com.nix.eugenia.controllers;

import com.nix.eugenia.exceptions.ResourceNotFoundException;
import com.nix.eugenia.model.Student;
import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.model.UpdateEntity;
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
    public void addStudent(@RequestBody Student student) {
         administratorService.addStudent(student);
    }

    /*
        @PutMapping(path = "/edit/students/{id}", consumes = "application/json", produces = "application/json")
        public void changeTeacher(@PathVariable (name ="id") Long studentID, @RequestBody Long teacherID) {
            administratorService.changeCurrentTeacher(studentID, teacherID);
        }
    */
    @PutMapping(path = "/edit/students/", consumes = "application/json", produces = "application/json")
    public void updateStudent(@Valid @RequestBody UpdateEntity updateEntity) throws ResourceNotFoundException {
         administratorService.updateStudent(updateEntity.getStudentId(), updateEntity.getTeacherId());
    }


    @DeleteMapping(path = "/delete/students")
    public void deleteStudent(@Valid @RequestBody UpdateEntity updateEntity) {
        administratorService.deleteStudent(updateEntity.getStudentId());
    }
}

