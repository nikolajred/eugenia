package com.nix.eugenia.controllers;

import com.nix.eugenia.model.Student;
import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.model.Timetable;
import com.nix.eugenia.repositories.StudentRepository;
import com.nix.eugenia.repositories.TeacherRepository;
import com.nix.eugenia.repositories.TimetableRepository;
import com.nix.eugenia.services.TeacherService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;
    private final TeacherRepository teacherRepository;

    @GetMapping ("/teacher/{id}")
    public Teacher getTeacherById(@PathVariable Long id){
        return teacherService.getTeacher(id);
    }

    @GetMapping("/teachers")
    List<Teacher> allTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping("teachers/{start_time}/{finish_time}")
    List<Teacher> getTeacherBySchedule(@PathVariable Calendar startTime, @PathVariable Calendar finishTime){
        return teacherService.getTeacherBySchedule(startTime, finishTime);
    }



//    @GetMapping("/timetable/teacher/{id}")
//    public Timetable getTeacherTimetableById(@PathVariable Long id)
//    {
//        return timetableRepository.getTeacherTimetable(id);
//    }



}
