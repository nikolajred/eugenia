package com.nix.eugenia.DTO;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class LessonStartDTO {

    private Long teacherId;
    private Long studentId;
    private String lessonName;
    private String videoName;
}
