package com.nix.eugenia.mapper;

import com.nix.eugenia.DTO.TimePeriodDTO;
import com.nix.eugenia.model.TimePeriod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TimePeriodMapper extends AbstractMapper<TimePeriod, TimePeriodDTO> {

    @Autowired
    public TimePeriodMapper() {
        super(TimePeriod.class, TimePeriodDTO.class);
    }
}
