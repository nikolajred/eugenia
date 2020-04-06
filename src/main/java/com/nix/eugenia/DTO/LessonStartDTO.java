package com.nix.eugenia.DTO;


import lombok.Data;

@Data
public class LessonStartDTO {

    private Long teacherId;
    private Long studentId;
    private String lessonName;
    private String videoName;
}
