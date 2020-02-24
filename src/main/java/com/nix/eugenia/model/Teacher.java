package com.nix.eugenia.model;

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
    private List<Schedul> schedul = new ArrayList<>();

    public void addSchedul(Schedul schedul) {
        this.schedul.add( schedul );
        schedul.getTeachers().add( this );
    }

    public void removeSchedul(Schedul schedul) {
        this.schedul.remove( schedul );
        schedul.getTeachers().remove( this );
    }

}

