package com.nix.eugenia.controllers;

import com.nix.eugenia.exceptions.StudentNotFoundException;
import com.nix.eugenia.model.Student;
import com.nix.eugenia.repositories.StudentRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public class AdministratorController {

    StudentRepository studentRepository;
    StudentController studentController;


  /*  @RequestMapping(value = "/edit-students", method = RequestMethod.POST)
    public Student editStudent(@RequestParam("studentId") Long studentID, Student model, Long payment) {

        try {
            Student newStudent = studentRepository.getOne(studentID);

            newStudent.payForLessons(payment);
            studentController.replaceStudent(newStudent, studentID);
            return newStudent;
        } catch (Exception e) {
            throw new StudentNotFoundException(studentID);
        }

    }*/
}
