package com.nix.eugenia.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LessonDTO {

    private String lessonName;
    private String videoRoomName;
    private Long studentId;
    private Long teacherId;

}
