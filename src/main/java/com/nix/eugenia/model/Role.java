package com.nix.eugenia.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.*;


@Getter
@Setter
@Entity
@Table(name = "role")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"name"})
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnoreProperties("roles")
    private List<User> users = new LinkedList<>();




}
