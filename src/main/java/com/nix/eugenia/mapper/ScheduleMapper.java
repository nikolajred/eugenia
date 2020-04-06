package com.nix.eugenia.mapper;

import com.nix.eugenia.DTO.TimetableDTO;
import com.nix.eugenia.model.Schedule;
import com.nix.eugenia.repositories.TimePeriodRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class ScheduleMapper extends AbstractMapper<Schedule, TimetableDTO> {

    private final ModelMapper mapper;
    private final TimePeriodRepository timePeriodRepository;

    @Autowired
    public ScheduleMapper(ModelMapper mapper, TimePeriodRepository timePeriodRepository) {
        super(Schedule.class, TimetableDTO.class);
        this.mapper = mapper;
        this.timePeriodRepository = timePeriodRepository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Schedule.class, TimetableDTO.class)
                .addMappings(m -> m.skip(TimetableDTO::setTimePeriodId)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(TimetableDTO.class, Schedule.class)
                .addMappings(m -> m.skip(Schedule::setTimePeriod)).setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFields(Schedule source, TimetableDTO destination) {
        destination.setTimePeriodId(getId(source));
    }

    private Long getId(Schedule source) {
        return Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getTimePeriod().getId();
    }

    @Override
    void mapSpecificFields(TimetableDTO source, Schedule destination) {
        destination.setTimePeriod(timePeriodRepository.findById(source.getTimePeriodId()).orElse(null));
    }

}
