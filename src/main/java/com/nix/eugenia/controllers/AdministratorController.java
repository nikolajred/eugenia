package com.nix.eugenia.controllers;

import com.nix.eugenia.DTO.StudentDTO;
import com.nix.eugenia.DTO.UpdateEntity;
import com.nix.eugenia.model.Student;
import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.model.TimePeriod;
import com.nix.eugenia.services.AdministratorService;
import com.nix.eugenia.services.AdministratorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class AdministratorController {

    private final AdministratorServiceImpl administratorServiceImpl;
    private final AdministratorService administratorService;


    @PutMapping(path = "/students/add", consumes = "application/json", produces = "application/json")
    public void addStudent(@RequestBody StudentDTO student) {
        administratorServiceImpl.addStudent(student);
    }

    @DeleteMapping(path = "/students/delete")
    public void deleteStudent(@Valid @RequestBody  StudentDTO studentDTO) {
        administratorServiceImpl.deleteStudent(studentDTO.getId());
    }

    @PutMapping(path = "/student/{id}/add/timetable", consumes = "application/json", produces = "application/json")
    public void addStudentTimetable(@PathVariable Long id, @RequestBody List<TimePeriod> lessonTimes) {
        administratorService.setStudentTimetable(id, lessonTimes);
    }
    @PutMapping(path = "/teacher/add/{teacherId}/to/students/{studentId}")
    public void addTeacherToStudentById(@PathVariable Long studentId, @PathVariable Long teacherId){
            administratorService.addTeacherToStudent(studentId, teacherId);
    }

    @PutMapping("teacher/{id}/schedule/add")
    public void addTeacherSchedule(@PathVariable Long id, @RequestBody List<TimePeriod> lessonTimes) {
        administratorService.setTeacherSchedule(id, lessonTimes);
    }

    @PutMapping("teacher/{id}/schedule/delete")
    public void deleteTeacherSchedule(@PathVariable Long id, @RequestBody TimePeriod lessonTimes) {
        administratorService.deleteTeacherSchedule(id, lessonTimes);
    }



//[{"startLesson":"2020-10-22'T'10:00", "endLesson":"2020-10-22'T'11:00"}, {"startLesson":"2020-10-25'T'10:00", "endLesson":"2020-10-25'T'11:00"}]
}

