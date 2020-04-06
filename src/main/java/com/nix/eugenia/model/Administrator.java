package com.nix.eugenia.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "administrator")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Administrator extends AbstractEntity {

    @Column
    private String name;
    @Column
    private String lastname;
    @Column
    private String login;
    @Column
    private String password;




}
