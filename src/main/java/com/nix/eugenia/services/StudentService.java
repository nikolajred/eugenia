package com.nix.eugenia.services;

import com.nix.eugenia.model.Student;
import com.nix.eugenia.model.TimePeriod;

import java.util.List;

public interface StudentService {

    public Student getStudent(Long id);
    public List<Student> getAllStudents();
//    List<Student> getStudentsByTimeTable(TimePeriod lessonPeriod);
    List<Student> getStudentByTimeTable(TimePeriod timePeriod);

}
