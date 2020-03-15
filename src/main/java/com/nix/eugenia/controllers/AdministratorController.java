package com.nix.eugenia.controllers;

import com.nix.eugenia.DTO.UpdateEntity;
import com.nix.eugenia.model.Student;
import com.nix.eugenia.services.AdministratorService;
import com.nix.eugenia.services.AdministratorServiceImpl;
import com.nix.eugenia.structures.LessonPeriod;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
public class AdministratorController {

    private final AdministratorService administratorService;


    @PostMapping(path = "/add/students", consumes = "application/json", produces = "application/json")
    public void addStudent(@RequestBody Student student) {
        administratorService.addStudent(student);
    }

    @DeleteMapping(path = "/delete/students")
    public void deleteStudent(@Valid @RequestBody UpdateEntity updateEntity) {
        administratorService.deleteStudent(updateEntity.getStudent().getId());
    }

    @PostMapping(path = "/student/{id}/add/timetable", consumes = "application/json", produces = "application/json")
    public void addStudentTimetable(@PathVariable Long id, @RequestBody List<LessonPeriod> lessonTimes) {
        administratorService.setStudentTimetable(id, lessonTimes);
    }

//    @PostMapping(path = "/student/{id}/edit/timetable", consumes = "application/json", produces = "application/json")
//    public void editStudentTimetable(@PathVariable Long id, Map<LessonPeriod, LessonPeriod> newLessonTime ) {
//        administratorService.changeStudentTimetable(id, newLessonTim, newLessonTime);
//    }

    @PostMapping(path = "/add/teacher/{teacherId}/to/students/{studentId}")
    public void addTeacherToStudent(@PathVariable Long studentId, @PathVariable Long teacherId) {
        administratorService.addTeacherToStudent(studentId, teacherId);
    }

}





