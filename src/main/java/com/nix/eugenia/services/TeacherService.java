package com.nix.eugenia.services;

import com.nix.eugenia.model.Teacher;
import org.joda.time.Interval;
import org.joda.time.LocalDateTime;

import java.util.List;

public interface TeacherService {
    Teacher getTeacher(Long id);
    List<Teacher>getTeacherByInterval(LocalDateTime start, LocalDateTime finish);
    List<Teacher>getAllTeachers();

}
