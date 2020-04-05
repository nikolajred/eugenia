package com.nix.eugenia.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nix.eugenia.model.Student;
import com.nix.eugenia.model.TimePeriod;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TimetableDTO extends AbstractDTO {

    private Long timePeriodId;
    @JsonIgnoreProperties("timetables")
    private List<Student> students;
}
