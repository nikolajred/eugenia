package com.nix.eugenia.services;

import com.nix.eugenia.DTO.StudentDTO;
import com.nix.eugenia.DTO.TeacherDTO;
import com.nix.eugenia.DTO.TimePeriodDTO;
import com.nix.eugenia.model.Schedule;
import com.nix.eugenia.model.Student;
import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.model.TimePeriod;


import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TeacherService {
    TeacherDTO getTeacherById(Long id);

    List<TeacherDTO> getTeacherByStartSchedule(Date startTime);

    //    List<Teacher> getTeacherByFullSchedule(Schedule lessonTime);
    List<TeacherDTO> getAllTeachers();

    List<TeacherDTO> getTeacherByName(String name);

    List<Teacher> getTeacherBySchedule(TimePeriod timePeriod);

    List<TimePeriodDTO> getTeacherSchedules(Long teacherId);

    public Map<TimePeriodDTO, StudentDTO> getTimetableByTeacherSchedule(Long teacherId, TimePeriod lessonTime);
}
