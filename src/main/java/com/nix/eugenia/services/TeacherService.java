package com.nix.eugenia.services;

import com.nix.eugenia.model.Schedule;
import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.model.TimePeriod;


import java.util.Date;
import java.util.List;

public interface TeacherService {
    Teacher getTeacherById(Long id);
    List<Teacher> getTeacherByStartSchedule(Date startTime);
//    List<Teacher> getTeacherByFullSchedule(Schedule lessonTime);
    List<Teacher>getAllTeachers();
    List<Teacher>getTeacherByName(String name);
    List<Teacher> getTeacherBySchedule(TimePeriod timePeriod);
}
