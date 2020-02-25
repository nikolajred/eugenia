package com.nix.eugenia.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.joda.time.Interval;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "schedul")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Schedul {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String interval;

    @ManyToMany(mappedBy = "schedul")
    @JsonIgnoreProperties("schedul")
    private List<Teacher> teachers = new ArrayList<>();


}

