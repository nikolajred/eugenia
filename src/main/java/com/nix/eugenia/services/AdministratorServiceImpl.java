package com.nix.eugenia.services;

import com.nix.eugenia.exceptions.ResourceNotFoundException;
import com.nix.eugenia.model.Schedule;
import com.nix.eugenia.model.Student;
import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.model.Timetable;
import com.nix.eugenia.repositories.StudentRepository;
import com.nix.eugenia.repositories.TeacherRepository;
import com.nix.eugenia.structures.LessonPeriod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AdministratorServiceImpl implements AdministratorService{

    private final StudentRepository studentRepository;
    private final StudentService studentService;
    private final TeacherRepository teacherRepository;
    private final TeacherService teacherService;
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

    @Override
    public void setStudentTimetable(Long studentId, List<LessonPeriod> lessonPeriods) {
        Student student = studentRepository.findById(studentId).get();
        List<Timetable> timetables = new ArrayList<>();
        lessonPeriods.forEach((s) -> timetables.add(new Timetable(s, studentService.getStudentsByTimeTable(s))));
        student.setTimetables(timetables);
        Teacher teacher = student.getTeacher();
        List<Schedule> schedules = new ArrayList<>();
        lessonPeriods.forEach((s) -> schedules.add(new Schedule(s, teacherService.getTeacherByFullSchedule(s))));
        teacher.setSchedules(schedules);
        studentRepository.save(student);
        teacherRepository.save(teacher);
    }

    @Override
    public void addTeacherToStudent(Long studentId, Long teacherId) {
        Student student = studentRepository.findById(studentId).get();
        student.setTeacher(teacherRepository.findById(teacherId).get());
        studentRepository.save(student);
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

