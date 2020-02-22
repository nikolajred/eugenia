package com.nix.eugenia.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "student")
@AllArgsConstructor
public class Student {


    private @Id
    @GeneratedValue
    Long id;
    private String name;
    private String role;
    private Long lessonsLeft;


    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher currentTeacher;




    Student() {
    }

    public Student(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public void payForLessons(Long payment){
        this.lessonsLeft += (payment/this.currentTeacher.getWage());
    }


}
