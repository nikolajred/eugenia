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

    public void addStudent(Student student) {
         studentRepository.findAll().add(student);

    }

    public void deleteStudent(Long studentID) {

        studentRepository.  deleteById(studentID);
    }

    public void updateStudent(Long studentId, Long teacherId) {


        teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("This teacher doesnt exist", teacherId))
                .getStudents().add(studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("This student doesn't exist", studentId)));

    }
}
