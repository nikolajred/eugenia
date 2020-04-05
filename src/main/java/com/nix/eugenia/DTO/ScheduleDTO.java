package com.nix.eugenia.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.model.TimePeriod;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ScheduleDTO extends AbstractDTO{

    private Long timePeriodId;
    @JsonIgnoreProperties("schedules")
    private List<Teacher> teachers;
}
