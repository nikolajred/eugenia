package com.nix.eugenia.model;

import com.nix.eugenia.exceptions.BadRequestException;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "timePeriod")
@EqualsAndHashCode(callSuper = false)
public class TimePeriod extends AbstractEntity {


    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date finishTime;

    @OneToMany(mappedBy = "timePeriod", cascade = CascadeType.ALL)
    private List<Timetable> timetables;

    @OneToMany(mappedBy = "timePeriod", cascade = CascadeType.ALL)
    private List<Schedule> schedules;



    public TimePeriod(Date startTime, Date finishTime) {
        if (startTime.compareTo(finishTime) >= 0) throw new BadRequestException("Incorrect time");
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public boolean isPeriodsCrosses(TimePeriod newTimePeriod){
        return (newTimePeriod.getStartTime().compareTo(startTime) >= 0 && newTimePeriod.getFinishTime().compareTo(finishTime) <= 0)
                || (newTimePeriod.getStartTime().before(finishTime) && newTimePeriod.getStartTime().after(startTime))
                || (newTimePeriod.getFinishTime().before(finishTime) && newTimePeriod.getFinishTime().after(startTime))
                || (newTimePeriod.getStartTime().compareTo(startTime) <= 0 && newTimePeriod.getFinishTime().compareTo(finishTime) >= 0);
    }

    public boolean isPeriodIn(TimePeriod timePeriod){
        return startTime.compareTo(timePeriod.getStartTime()) >= 0 && finishTime.compareTo(timePeriod.getFinishTime()) <= 0;
    }

    @Override
    public String toString() {
        return "TimePeriod{" +
                "startTime=" + startTime +
                ", finishTime=" + finishTime +
                '}';
    }
}
