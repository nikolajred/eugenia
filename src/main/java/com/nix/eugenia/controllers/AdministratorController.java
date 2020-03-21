package com.nix.eugenia.controllers;

import com.nix.eugenia.DTO.AdminUserDto;
import com.nix.eugenia.DTO.UpdateEntity;
import com.nix.eugenia.model.Student;
import com.nix.eugenia.model.User;
import com.nix.eugenia.services.AdministratorService;
import com.nix.eugenia.services.AdministratorServiceImpl;
import com.nix.eugenia.services.UserService;
import com.nix.eugenia.structures.LessonPeriod;
import lombok.AllArgsConstructor;
;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/api/admin/")
public class AdministratorController {

    private final AdministratorServiceImpl administratorServiceImpl;
    private final AdministratorService administratorService;
    private final UserService userService;
    @Autowired
    public AdministratorController(AdministratorServiceImpl administratorServiceImpl, AdministratorService administratorService, UserService userService) {
        this.administratorServiceImpl = administratorServiceImpl;
        this.administratorService = administratorService;
        this.userService = userService;
    }

    @PostMapping(path = "/add/students", consumes = "application/json", produces = "application/json")
    public void addStudent(@RequestBody Student student) {
        administratorServiceImpl.addStudent(student);
    }

    @DeleteMapping(path = "/delete/students")
    public void deleteStudent(@Valid @RequestBody UpdateEntity updateEntity) {
        administratorServiceImpl.deleteStudent(updateEntity.getStudent().getId());
    }

    @PostMapping(path = "/student/{id}/add/timetable", consumes = "application/json", produces = "application/json")
    public void addStudent(@PathVariable Long id, @RequestBody List<LessonPeriod> lessonTimes) {
        administratorService.setStudentTimetable(id, lessonTimes);
    }
    @PostMapping(path = "/add/teacher/{teacherId}/to/students/{studentId}")
    public void addTeacherToStudentById(@PathVariable Long studentId, @PathVariable Long teacherId){
            administratorService.addTeacherToStudent(studentId, teacherId);
    }
    @GetMapping(value = "users/{id}")
    public ResponseEntity<AdminUserDto> getUserById(@PathVariable(name = "id") Long id) {
        User user = userService.findById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        AdminUserDto result = AdminUserDto.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}

