package com.nix.eugenia.services;

import com.nix.eugenia.exceptions.TeacherNotFoundException;
import com.nix.eugenia.model.Schedule;
import com.nix.eugenia.model.Student;
import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.model.TimePeriod;
import com.nix.eugenia.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<Teacher> getTeacherByStartSchedule(Date startTime) {
        return teacherRepository.findAll().stream().filter(teacher -> teacher.getSchedules()
                .stream().anyMatch(timetable -> timetable.getTimePeriod().getStartTime().equals(startTime))).collect(Collectors.toList());
    }

//    @Override
//    public List<Teacher> getTeacherByFullSchedule(Schedule lessonTime) {
//        return  teacherRepository.findByPeriod(Timestamp.from(lessonTime.getTimePeriod().getStartTime().toInstant()), Timestamp.from(lessonTime.getTimePeriod().getFinishTime().toInstant()));
//    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public List<Teacher> getTeacherByName(String name) {
        return teacherRepository.findAllByName(name);
    }

    @Override
    public List<Teacher> getTeacherBySchedule(TimePeriod timePeriod) {
        return teacherRepository.findAll().stream().filter(teacher -> teacher.getSchedules()
                .stream().anyMatch(schedules -> schedules.getTimePeriod().getId() == timePeriod.getId())).collect(Collectors.toList());
    }


    public List<Student> getStudentsByTeacherId(Long teacherId){
        return teacherRepository.findById(teacherId).get().getStudents();
    }
}
