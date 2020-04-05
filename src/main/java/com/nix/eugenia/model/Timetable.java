package com.nix.eugenia.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "timetable")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Timetable extends AbstractEntity {


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "time_period_id")
//    @JsonIgnoreProperties("timetables")
//    @JsonBackReference
    private TimePeriod timePeriod;


    @ManyToMany(mappedBy = "timetables")
//    @JsonIgnoreProperties("timetables")
//    @JsonBackReference(value = "student")
    private List<Student> students;


    public Timetable(TimePeriod timePeriod, List<Student> students) {
        this.timePeriod = timePeriod;
        this.students = students;
    }



}
