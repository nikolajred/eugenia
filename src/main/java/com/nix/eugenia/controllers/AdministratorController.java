package com.nix.eugenia.controllers;

import com.nix.eugenia.DTO.UpdateEntity;
import com.nix.eugenia.exceptions.ResourceNotFoundException;
import com.nix.eugenia.model.Student;
import com.nix.eugenia.services.AdministratorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


    @RestController
    @RequiredArgsConstructor
    public class AdministratorController {

        private final AdministratorServiceImpl administratorServiceImpl;


        @PostMapping(path = "/add/students", consumes = "application/json", produces = "application/json")
        public void addStudent(@RequestBody Student student) {
            administratorServiceImpl.addStudent(student);
        }


        //TODO
        @PutMapping(path = "/changeteacher/students", consumes = "application/json", produces = "application/json")
        public void changeCurrentTeacher(@Valid @RequestBody UpdateEntity updateEntity ) throws ResourceNotFoundException {
            administratorServiceImpl.changeCurrentTeacher(updateEntity.getStudent(), updateEntity.getTeacher());
        }
        //functional
        @PutMapping(path = "/edit/students", consumes = "application/json", produces = "application/json")
        public void updateStudent(@Valid @RequestBody UpdateEntity updateEntity ) throws ResourceNotFoundException {
            administratorServiceImpl.updateStudentLessons(updateEntity.getStudent());
        }

        //functional
        @DeleteMapping(path = "/delete/students")
        public void deleteStudent(@Valid @RequestBody UpdateEntity updateEntity) {
            administratorServiceImpl.deleteStudent(updateEntity.getStudent().getId());
        }

    }

