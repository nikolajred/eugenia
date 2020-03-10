package com.nix.eugenia.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column
    private String name;
    @Column
    private String role;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @JsonBackReference
    private Teacher teacher;

    @OneToMany(mappedBy = "student")
    @JsonIgnoreProperties("student")
    private List<Timetable> timetable;
    @Column
    private Long lessonsLeft;


    public Student(String name, String role) {
        this.name = name;
        this.role = role;
    }
}





    /*
        public void addTeacher(Teacher teacher) {
            teachersTaughtMe.add(teacher);
            teacher.getStudent().add(this);
        }

        public void removeTeacher(Teacher teacher ) {
            teachersTaughtMe.remove(teacher);
            teacher.getPosts().remove(this);
        }

    */

