package com.nix.eugenia.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nix.eugenia.model.Schedule;
import com.nix.eugenia.model.Timetable;
import lombok.*;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TimePeriodDTO extends AbstractDTO{

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    private Date startTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    private Date finishTime;


}
