package com.nix.eugenia.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import java.util.*;

@Data
@Getter
@Setter
@Entity
@Table(name = "role")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ={"name"})
public class Role extends BaseEntity{
    @Column
    private String name;

    @ManyToMany(mappedBy = "roles" , fetch = FetchType.LAZY)
    @JsonIgnoreProperties("roles")
    private List<User> users = new LinkedList<>();

    @Override
    public String toString() {
        return "Role{" +
                "id: " + super.getId() + ", " +
                "name: " + name + "}";
    }

}
