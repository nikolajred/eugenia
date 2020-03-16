package com.nix.eugenia.services;

import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.structures.LessonPeriod;

import java.util.List;

public interface AdministratorService {


    public List<Teacher> addTeacher();
    public List<Teacher> removeTeacher();
    public List<Teacher> updateTeacher();
    public void setStudentTimetable(Long studentId, List<LessonPeriod> lessonTimeList);
    public void addTeacherToStudent(Long studentId, Long teacherId);


}
