package com.nix.eugenia.services;

import com.nix.eugenia.model.Student;
import com.nix.eugenia.structures.LessonPeriod;

import java.util.List;

public interface StudentService {

    public Student getStudent(Long id);
    public List<Student> getAllStudents();
    List<Student> getStudentsByTimeTable(LessonPeriod lessonPeriod);


}
