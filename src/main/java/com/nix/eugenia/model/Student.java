package com.nix.eugenia.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "student")
@AllArgsConstructor
public class Student {



        private @Id @GeneratedValue Long id;
        private String name;
        private String role;

        Student() {}

        public Student(String name, String role) {
            this.name = name;
            this.role = role;
        }
    }
