package com.nix.eugenia.controllers;

import com.nix.eugenia.DTO.LessonDTO;
import com.nix.eugenia.DTO.LessonStartDTO;
import com.nix.eugenia.model.TeacherPrivateRoom;
import com.nix.eugenia.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teachers/room/{id}")
@RequiredArgsConstructor
public class TeacherRoomController {


    private final TeacherService teacherService;


    @PostMapping
    public String startLesson(@RequestBody LessonStartDTO lessonStartDTO) {

        teacherService.startLesson( lessonStartDTO.getTeacherId(),lessonStartDTO.getStudentId()
                ,lessonStartDTO.getLessonName(),lessonStartDTO.getVideoName());

        return "with student  ";
    }


    @PostMapping(path = "/stop")
    public String finishLesson(@RequestBody LessonStartDTO lessonStartDTO) {

        return   teacherService.finishLesson(lessonStartDTO.getStudentId());

    }
}
