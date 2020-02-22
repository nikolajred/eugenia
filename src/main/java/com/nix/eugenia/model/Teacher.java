package com.nix.eugenia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "teacher")
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String lastname;



    public Teacher(String name) {
        this.name = name;
    }

   /* @ManyToMany(mappedBy = "student")
    //@OneToMany
    @JoinColumn(name = "student_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(name = "student_teacher",
           joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
           inverseJoinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id"))*/
    private List<Student> students = new ArrayList<>();
}
