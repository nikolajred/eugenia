package com.nix.eugenia.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "teacher")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String lastname;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties("teachers")
    private List<Schedule> schedule = new ArrayList<>();

    public void addSchedule(Schedule schedule) {
        this.schedule.add(schedule);
        schedule.getTeachers().add(this);
    }

    public void removeSchedule(Schedule schedule) {
        this.schedule.remove(schedule);
        schedule.getTeachers().remove(this);
    }

}

