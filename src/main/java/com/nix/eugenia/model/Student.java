package com.nix.eugenia.model;


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
public class Student {



        private @Id @GeneratedValue Long id;
        private String name;
        private String role;

        @ManyToMany(cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
        })
        @JoinTable(name = "student_teacher",
                joinColumns = @JoinColumn(name = "student_id"),
                inverseJoinColumns = @JoinColumn(name = "teacher_id")
        )
        private List<Teacher> teachersTaughtMe = new ArrayList<>();
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
        Student() {}

        public Student(String name, String role) {
            this.name = name;
            this.role = role;
        }
    }
