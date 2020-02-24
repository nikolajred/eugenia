package com.nix.eugenia.model;
import lombok.*;
import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "role")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ={"name"})
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;

}
