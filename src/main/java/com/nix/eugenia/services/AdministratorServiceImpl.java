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
public class AdministratorServiceImpl implements AdministratorService{

    private final StudentRepository studentRepository;

    private final TeacherRepository teacherRepository;
    @Override
    public List<Teacher> addTeacher() {
        return null;
    }

    @Override
    public List<Teacher> removeTeacher() {
        return null;
    }

    @Override
    public List<Teacher> updateTeacher() {
        return null;
    }
    public void changeCurrentTeacher(Student student, Teacher teacher) {

        teacher.getStudents().add(student);
        teacherRepository.save(teacher);

    }

    public void addStudent(Student student) {
        studentRepository.save(student);

    }

    public void deleteStudent(Long studentID) {

        studentRepository.deleteById(studentID);
    }

    public void updateStudent(Long studentId, Long teacherId) {


        teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("This teacher doesnt exist", teacherId))
                .getStudents().add(studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("This student doesn't exist", studentId)));

    }

    public void updateStudentLessons(Student student) {

        Student newStudent = studentRepository.findById(student.getId())
                .orElseThrow(() -> new ResourceNotFoundException("This student doesn't exist", student.getId()));

        student.setLessonsLeft(student.getLessonsLeft());
        studentRepository.save(newStudent);
    }


}

