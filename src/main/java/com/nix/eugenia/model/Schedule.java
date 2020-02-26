package com.nix.eugenia.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.joda.time.Interval;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "schedule")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Calendar startTime;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Calendar finishTime;

    @ManyToMany(mappedBy = "schedule")
    @JsonIgnoreProperties("schedule")
    private List<Teacher> teachers = new ArrayList<>();


}

