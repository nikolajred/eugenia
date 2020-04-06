package com.nix.eugenia.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nix.eugenia.model.Schedule;
import com.nix.eugenia.model.Student;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TeacherDTO extends AbstractDTO{

    private String name;
    private String lastname;
    private String email;
    @JsonIgnoreProperties("teachers")
    private List<Schedule> schedules;
    private List<Student> students;

}
