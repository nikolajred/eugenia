package com.nix.eugenia.mapper;

import com.nix.eugenia.DTO.TimetableDTO;
import com.nix.eugenia.model.TimePeriod;
import com.nix.eugenia.model.Timetable;
import com.nix.eugenia.repositories.TimePeriodRepository;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class TimetableMapper extends AbstractMapper<Timetable, TimetableDTO> {

    private final ModelMapper mapper;
    private final TimePeriodRepository timePeriodRepository;

    @Autowired
    public TimetableMapper(ModelMapper mapper, TimePeriodRepository timePeriodRepository) {
        super(Timetable.class, TimetableDTO.class);
        this.mapper = mapper;
        this.timePeriodRepository = timePeriodRepository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Timetable.class, TimetableDTO.class)
                .addMappings(m -> m.skip(TimetableDTO::setTimePeriodId)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(TimetableDTO.class, Timetable.class)
                .addMappings(m -> m.skip(Timetable::setTimePeriod)).setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFields(Timetable source, TimetableDTO destination) {
        destination.setTimePeriodId(getId(source));
    }

    private Long getId(Timetable source) {
        return Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getTimePeriod().getId();
    }

    @Override
    void mapSpecificFields(TimetableDTO source, Timetable destination) {
        destination.setTimePeriod(timePeriodRepository.findById(source.getTimePeriodId()).orElse(null));
    }



}


