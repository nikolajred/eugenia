package com.nix.eugenia.services;

import com.nix.eugenia.model.Teacher;
import org.joda.time.Interval;

import java.util.List;

public interface TeacherService {
    Teacher getTeacher(Long id);
    List<Teacher>getTeacherByInterval(Interval interval);

}
