package com.nix.eugenia.services;

import com.nix.eugenia.model.Teacher;


import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

public interface TeacherService {
    Teacher getTeacher(Long id);
    List<Teacher>getTeacherBySchedule(Calendar start, Calendar finish);
    List<Teacher>getAllTeachers();

}
