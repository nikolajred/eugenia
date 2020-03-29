package com.nix.eugenia.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "timetable")
@NoArgsConstructor
@AllArgsConstructor
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "time_period_id")
    @JsonIgnoreProperties("timetables")
    @JsonBackReference
    private TimePeriod timePeriod;


    @ManyToMany(mappedBy = "timetables")
    @JsonIgnoreProperties("timetables")
    @JsonBackReference(value = "student")
    private List<Student> students;


    public Timetable(TimePeriod timePeriod, List<Student> students) {
        this.timePeriod = timePeriod;
        this.students = students;
    }




}
