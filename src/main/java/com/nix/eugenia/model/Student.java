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
   /* @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Teacher myCurrentTeacher;
    @ManyToMany(mappedBy = "teacher")
    private Set<Teacher> teachers;

*/


    Student() {
    }

    public Student(String name, String role) {
        this.name = name;
        this.role = role;
    }


}
