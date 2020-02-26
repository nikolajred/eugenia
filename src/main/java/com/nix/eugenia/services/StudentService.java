package com.nix.eugenia.services;

import com.nix.eugenia.model.Student;
import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.repositories.StudentRepository;
import com.nix.eugenia.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    public Student getStudent(Long id) {
        return studentRepository.getOne(id);
    }

    public List<Student> getAllStudents(){
        return  studentRepository.findAll();
        }

}
