package com.nix.eugenia.controllers;

import com.nix.eugenia.model.Student;
import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.repositories.TeacherRepository;
import com.nix.eugenia.services.TeacherService;
import com.nix.eugenia.services.TeacherServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private  final TeacherServiceImpl teacherServiceImpl;
    private final TeacherService teacherService;
    private final TeacherRepository teacherRepository;

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @GetMapping
    public List<Teacher> getAllTeachersOfList() {
        return teacherService.getAllTeachers();
    }

    @GetMapping(params = "startTime")
    public List<Teacher> getTeacherBySchedule(
            @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") @RequestParam(name = "startTime") Date startTime
    ) {
        return teacherService.getTeacherBySchedule(startTime);
    }

    @GetMapping(params = "name")
    public List<Teacher> getTeacherByName(@RequestParam(name = "name") String name) {
        return teacherService.getTeacherByName(name);
    }

    @GetMapping("/students/{id}")
    public List<Student> getTeacherByName(@PathVariable(name = "id")  Long teacherId) {
        return teacherServiceImpl.getStudentsByTeacherId(teacherId);
    }


}
