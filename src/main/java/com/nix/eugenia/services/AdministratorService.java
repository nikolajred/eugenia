package com.nix.eugenia.services;

import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.model.TimePeriod;
import com.nix.eugenia.model.Timetable;

import java.util.List;

public interface AdministratorService {


    List<Teacher> addTeacher();
    List<Teacher> removeTeacher();
    List<Teacher> updateTeacher();
    void setStudentTimetable(Long studentId, List<TimePeriod> lessonTimes);
    void addTeacherToStudent(Long studentId, Long teacherId);
    void setTeacherSchedule(Long teacherId, List<TimePeriod> workingTimes);
    void deleteTeacherSchedule(Long teacherId, TimePeriod workingTimes);


}
