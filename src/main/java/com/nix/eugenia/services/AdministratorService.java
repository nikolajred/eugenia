package com.nix.eugenia.services;

import com.nix.eugenia.model.Student;
import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.repositories.StudentRepository;
import com.nix.eugenia.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AdministratorService {

    private  StudentRepository studentRepository;

    private  TeacherRepository teacherRepository;


    public List<Teacher> addTeacher() {
        return null;
    }

    public List<Teacher> removeTeacher() {
        return null;
    }


    public List<Teacher> updateTeacher() {
        return null;
    }


    public void changeCurrentTeacher(Long studentID, Long teacherID){

        studentRepository.findById(studentID).get().setCurrentTeacher(teacherRepository.getOne(teacherID));
    }

    public void  addStudent(Student student){
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentID){
        studentRepository.delete(studentRepository.getOne(studentID));
    }
}
