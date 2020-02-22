package com.nix.eugenia.services;

import com.nix.eugenia.model.DayOfWeek;
import com.nix.eugenia.model.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher getTeacher(Long id);
    List<Teacher>getTeacherByTimeAndDay(DayOfWeek dayOfWeek, String workDay);
}
