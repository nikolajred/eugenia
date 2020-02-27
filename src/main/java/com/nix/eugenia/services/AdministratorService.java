package com.nix.eugenia.services;

import com.nix.eugenia.exceptions.ResourceNotFoundException;
import com.nix.eugenia.model.Student;
import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.repositories.StudentRepository;
import com.nix.eugenia.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdministratorService {

    private StudentRepository studentRepository;

    private TeacherRepository teacherRepository;


    public List<Teacher> addTeacher() {
        return null;
    }

    public List<Teacher> removeTeacher() {
        return null;
    }


    public List<Teacher> updateTeacher() {
        return null;
    }


    public void changeCurrentTeacher(Long studentID, Long teacherID) {

        studentRepository.findById(studentID).get().setCurrentTeacher(teacherRepository.getOne(teacherID));
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long studentID) {

        studentRepository.deleteById(studentID);
    }

    public Student updateStudent(Long studentId, Long teacherId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("student not found for this id : ", studentId));

        student.setCurrentTeacher(teacherRepository.findById(teacherId).get());
        final Student updatedStudent = studentRepository.save(student);
        return student;
    }
}
