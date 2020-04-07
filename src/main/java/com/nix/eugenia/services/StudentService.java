package com.nix.eugenia.services;

import com.nix.eugenia.DTO.StudentDTO;
import com.nix.eugenia.model.Student;
import com.nix.eugenia.model.TimePeriod;

import java.util.List;

public interface StudentService {

    public StudentDTO getStudent(Long id);
    public List<StudentDTO> getAllStudents();
//    List<Student> getStudentsByTimeTable(TimePeriod lessonPeriod);
    List<Student> getStudentByTimeTable(TimePeriod timePeriod);
    String joinLesson(Long studentId);

}
