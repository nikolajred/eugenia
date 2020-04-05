package com.nix.eugenia.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.model.Timetable;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDTO extends AbstractDTO {

    private String name;
    private String role;
    private Long teacherId;
    @JsonIgnoreProperties("students")
    private List<Timetable> timetables;
    private Long lessonsLeft;
}
