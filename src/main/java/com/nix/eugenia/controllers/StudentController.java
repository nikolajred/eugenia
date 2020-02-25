package com.nix.eugenia.controllers;

import com.nix.eugenia.exceptions.StudentNotFoundException;
import com.nix.eugenia.model.Student;

import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.CollectionModel;


import javax.persistence.PostUpdate;
import java.util.List;


@RestController
//@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository repository;

    StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/students")
    List<Student> all() {
        return repository.findAll();
    }

    @PostMapping("/students")
    Student newStudent(@RequestBody Student newStudent) {
        return repository.save(newStudent);
    }

    // Single item

    @GetMapping("/students/{id}")
    EntityModel<Student> one(@PathVariable Long id) {

        Student student = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        return new EntityModel<>(student,
                linkTo(methodOn(StudentController.class).one(id)).withSelfRel(),
                linkTo(methodOn(StudentController.class).all()).withRel("students"));
    }

    @PutMapping("/students/{id}")
    Student replaceStudent(@RequestBody Student newStudent, @PathVariable Long id) {

        return repository.findById(id)
                .map(student -> {
                    student.setName(newStudent.getName());
                    student.setRole(newStudent.getRole());
                    return repository.save(student);
                })
                .orElseGet(() -> {
                    newStudent.setId(id);
                    return repository.save(newStudent);
                });
    }



    @DeleteMapping("/students/{id}")
    void deleteStudent(@PathVariable Long id) {
        repository.deleteById(id);
    }





}
