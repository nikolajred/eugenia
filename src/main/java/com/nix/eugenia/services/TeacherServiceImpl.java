package com.nix.eugenia.services;

import com.nix.eugenia.exceptions.TeacherNotFoundException;
import com.nix.eugenia.model.Student;
import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.repositories.TeacherRepository;
import com.nix.eugenia.structures.LessonPeriod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;


    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException(id));
    }

    @Override
    public List<Teacher> getTeacherBySchedule(Date startTime) {
        return  teacherRepository.findByStartTime(Timestamp.from(startTime.toInstant()));
    }

    @Override
    public List<Teacher> getTeacherByFullSchedule(LessonPeriod lessonTime) {
        return  teacherRepository.findByPeriod(Timestamp.from(lessonTime.getStartLesson().toInstant()), Timestamp.from(lessonTime.getEndLesson().toInstant()));
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public List<Teacher> getTeacherByName(String name) throws TeacherNotFoundException{
        return teacherRepository.findAllByName(name);
    }


    public List<Student> getStudentsByTeacherId(Long teacherId){
        return teacherRepository.findById(teacherId).get().getStudents();
    }
}
