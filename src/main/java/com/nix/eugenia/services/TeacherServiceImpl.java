
package com.nix.eugenia.services;

import com.nix.eugenia.exceptions.ResourceNotFoundException;
import com.nix.eugenia.exceptions.TeacherNotFoundException;
import com.nix.eugenia.model.Schedule;
import com.nix.eugenia.model.Student;
import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.repositories.ScheduleRepository;
import com.nix.eugenia.repositories.StudentRepository;
import com.nix.eugenia.repositories.TeacherRepository;
import com.nix.eugenia.structures.LessonPeriod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final ScheduleRepository scheduleRepository;
    private final StudentRepository studentRepository;


    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException(id));
    }

    @Override
    public List<Teacher> getTeacherBySchedule(Date startTime) {
        return teacherRepository.findTeachersByStartTime(Timestamp.from(startTime.toInstant()));
    }


    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public List<Teacher> getTeacherByName(String name) {
        return teacherRepository.findAllByName(name);
    }

    @Override
    public List<Student> getStudentsByTeacherId(Long teacherId) {
        return teacherRepository.findById(teacherId).get().getStudents();
    }

    @Override
    public String startLesson(Long teacherId, Long studentId,
                              String lessonName, String videoName) {

        Student newStudent = studentRepository.findById(studentId).orElseThrow(()->
        new ResourceNotFoundException("I'm sorry but there's no student ", studentId));
             newStudent.setVideoLesson(videoName);
             newStudent.setCanJoinLesson(true);
             studentRepository.save(newStudent);
        return videoName+"   "+ lessonName;
    }

    @Override
    public void addSchedule(Long id, List<LessonPeriod> lessonTimeList) {

        Teacher newTeacher = teacherRepository.findById(id).get();

        List<Schedule> updatedSchedule = new ArrayList<>();

        updatedSchedule.addAll( newTeacher.getSchedules());
        //updatedSchedule.addAll( teacher.getSchedules());
        newTeacher.setSchedules(updatedSchedule);

        teacherRepository.save(newTeacher);

    }

    @Override
    public String finishLesson(Long studentId) {

        Student newStudent = studentRepository.findById(studentId).orElseThrow(()->
                new ResourceNotFoundException("I'm sorry but there's no student ", studentId));
        newStudent.setVideoLesson("lesson hasn't been started yet");
        newStudent.setCanJoinLesson(false);
        studentRepository.save(newStudent);
        return "lesson has been stopped";

    }

}
