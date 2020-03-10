package com.nix.eugenia.services;

import com.nix.eugenia.exceptions.ResourceNotFoundException;
import com.nix.eugenia.model.Student;
import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.repositories.StudentRepository;
import com.nix.eugenia.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
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


    public void changeCurrentTeacher(Long studentId, Long teacherId) {
        Student student = studentRepository.findById(studentId).get();
        Teacher teacher = teacherRepository.findById(teacherId).get();
        student.setTeacher(teacher);
        teacher.getStudents().add(student);
        teacherRepository.save(teacher);
    }

    public void addStudent(Student student) {
        studentRepository.save(student);

    }

    public void deleteStudent(Long studentID) {

        studentRepository.deleteById(studentID);
    }



    public void updateStudentLessons(Long studentId, Long lessonsLeft) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("This student doesn't exist", studentId));

        student.setLessonsLeft((Long) student.getLessonsLeft()+lessonsLeft);

        studentRepository.save(student);
    }


}

