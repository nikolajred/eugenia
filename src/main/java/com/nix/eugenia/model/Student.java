package com.nix.eugenia.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "student")
@AllArgsConstructor
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column
    private String name;
    @Column
    private String role;

    @OneToMany(mappedBy="student")
    @JsonIgnoreProperties("student")
    private List<Timetable> timetable;

    @ManyToOne
    @JoinColumn(name="teacher_id", nullable=false, referencedColumnName = "id")
    @JsonBackReference
    private Teacher teacher;

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
    Student() {
    }

    public Student(String name, String role) {
        this.name = name;
        this.role = role;
    }
}
