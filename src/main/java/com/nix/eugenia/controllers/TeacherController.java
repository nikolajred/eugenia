package com.nix.eugenia.controllers;

import com.nix.eugenia.DTO.StudentDTO;
import com.nix.eugenia.DTO.TeacherDTO;
import com.nix.eugenia.DTO.TimePeriodDTO;
import com.nix.eugenia.model.Student;
import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.model.TimePeriod;
import com.nix.eugenia.repositories.TeacherRepository;
import com.nix.eugenia.services.TeacherService;
import com.nix.eugenia.services.TeacherServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherServiceImpl teacherServiceImpl;
    private final TeacherService teacherService;
    private final TeacherRepository teacherRepository;

    @GetMapping("/{id}")
    public TeacherDTO getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @GetMapping
    public List<TeacherDTO> getAllTeachersOfList() {
        return teacherService.getAllTeachers();
    }

    @GetMapping(params = "startTime")
    public List<TeacherDTO> getTeacherBySchedule(
            @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") @RequestParam(name = "startTime") Date startTime) {
        return teacherService.getTeacherByStartSchedule(startTime);
    }

    @GetMapping(params = "name")
    public List<TeacherDTO> getTeacherByName(@RequestParam(name = "name") String name) {
        return teacherService.getTeacherByName(name);
    }

    @GetMapping("/{id}/schedules")
    public List<TimePeriodDTO> getTeacherSchedules(@PathVariable(name = "id") Long teacherId) {
        return teacherServiceImpl.getTeacherSchedules(teacherId);
    }

    @PutMapping("/{id}/students/timetables")
    public  Map<TimePeriodDTO, StudentDTO> getTeacherStudentsTimetablesInThisSchedule(@PathVariable(name = "id") Long teacherId, @RequestBody TimePeriod lessonTimes) {
        return teacherServiceImpl.getTimetableByTeacherSchedule(teacherId, lessonTimes);
    }


}
