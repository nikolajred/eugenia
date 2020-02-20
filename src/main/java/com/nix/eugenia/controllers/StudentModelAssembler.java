package com.nix.eugenia.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import com.nix.eugenia.model.Student;

import org.springframework.stereotype.Component;

@Component
class StudentModelAssembler implements RepresentationModelAssembler<Student, EntityModel<Student>> {


    @Override
    public EntityModel<Student> toModel(Student student) {

        return new EntityModel<>(student,
                linkTo(methodOn(StudentController.class).one(student.getId())).withSelfRel(),
                linkTo(methodOn(StudentController.class).all()).withRel("students"));
    }
}

