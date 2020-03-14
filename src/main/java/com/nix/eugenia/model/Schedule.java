package com.nix.eugenia.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nix.eugenia.structures.LessonPeriod;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "schedule")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Column(name = "finish_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finishTime;

    @ManyToMany(mappedBy = "schedules")
    @JsonIgnoreProperties("schedules")
    private List<Teacher> teachers = new ArrayList<>();

    public Schedule(LessonPeriod lessonPeriod, List<Teacher> teachers){
        this.startTime = lessonPeriod.getStartLesson();
        this.finishTime = lessonPeriod.getEndLesson();
        this.teachers = teachers;

    }
}

