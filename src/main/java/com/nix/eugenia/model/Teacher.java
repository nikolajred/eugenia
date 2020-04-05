package com.nix.eugenia.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "teacher")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"email"}, callSuper = false)
public class Teacher extends AbstractEntity {


    @Column
    private String name;
    @Column(name = "`last_name`")
    private String lastname;
    @Column
    private String email;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "teacher_schedules",
            joinColumns = @JoinColumn(name = "teachers_id"),
            inverseJoinColumns = @JoinColumn(name = "schedules_id"))
//    @JsonIgnoreProperties("teachers")
    private List<Schedule> schedules = new ArrayList<>();


    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Student> students;




    public void addSchedule(Schedule schedule) {
        schedules.add(schedule);
        schedule.getTeachers().add(this);
    }

    public void removeSchedule(Schedule schedule) {
        schedules.remove(schedule);
        schedule.getTeachers().remove(this);
    }

    public boolean isLessonInWorkingTime(TimePeriod timePeriod){
        for (Schedule schedule : schedules) {
            if (schedule.getTimePeriod().getStartTime().compareTo(timePeriod.getStartTime()) <= 0 && schedule.getTimePeriod().getFinishTime().compareTo(timePeriod.getFinishTime()) >= 0)
                return true;
        }
        return false;
    }


}

