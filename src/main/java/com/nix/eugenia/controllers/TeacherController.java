package com.nix.eugenia.controllers;

import com.nix.eugenia.model.Schedule;
import com.nix.eugenia.model.Student;
import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.model.Timetable;
import com.nix.eugenia.repositories.StudentRepository;
import com.nix.eugenia.repositories.TeacherRepository;
import com.nix.eugenia.repositories.TimetableRepository;
import com.nix.eugenia.services.TeacherService;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;
    private final TeacherRepository teacherRepository;

    @GetMapping ("/teacher/{id}")
    public Teacher getTeacherById(@PathVariable Long id){
        return teacherService.getTeacherById(id);
    }

    @GetMapping("/teachers")
    List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @RequestMapping(value = "/time",consumes ="application/json", produces= "application/json", method = RequestMethod.GET)
    List<Teacher> getTeacherBySchedule(@DateTimeFormat Date startTime){
        return teacherService.getTeacherBySchedule(startTime);
    }



}
