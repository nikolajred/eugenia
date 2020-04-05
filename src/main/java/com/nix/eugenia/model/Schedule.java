package com.nix.eugenia.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "schedule")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Schedule extends AbstractEntity {


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "time_period_id")
//    @JsonBackReference
//    @JsonIgnoreProperties("schedule")
    private TimePeriod timePeriod;





    @ManyToMany(mappedBy = "schedules")
//    @JsonIgnoreProperties("schedules")
    private List<Teacher> teachers;

    public Schedule(TimePeriod timePeriod, List<Teacher> teachers) {
        this.timePeriod = timePeriod;
        this.teachers = teachers;
    }

}

