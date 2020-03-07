package com.nix.eugenia.services;

import com.nix.eugenia.model.Schedule;
import com.nix.eugenia.model.Teacher;


import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public interface TeacherService {
    Teacher getTeacherById(Long id);
    List<Teacher>getTeacherBySchedule(Date startTime);
    List<Teacher>getAllTeachers();

}
