package com.nix.eugenia.services;

import com.nix.eugenia.exceptions.ResourceNotFoundException;
import com.nix.eugenia.exceptions.TeacherNotFoundException;
import com.nix.eugenia.model.*;
import com.nix.eugenia.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.sql.Timestamp;
import java.util.*;
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

    @Override
    public List<TimePeriod> getTeacherSchedules(Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new ResourceNotFoundException("This teacher doesn't exist", teacherId));
        List<TimePeriod> timePeriods = new ArrayList<>();
        for (Schedule schedule : teacher.getSchedules()) {
            timePeriods.add(schedule.getTimePeriod());
        }
        return timePeriods;
    }

    @Override
    public Map<TimePeriod, Student> getTimetableByTeacherSchedule(Long teacherId, TimePeriod lessonTime) {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new ResourceNotFoundException("This teacher doesn't exist", teacherId));
        Map<TimePeriod, Student> timePeriods = new HashMap<>();
        for (Student student : teacher.getStudents()) {
            for (Timetable timetable : student.getTimetables()) {
                if (timetable.getTimePeriod().isPeriodIn(lessonTime)){
                    timePeriods.put(timetable.getTimePeriod(), student);
                }
            }
        }
        return timePeriods;
    }


    public List<Student> getStudentsByTeacherId(Long teacherId) {
        return teacherRepository.findById(teacherId).get().getStudents();
    }


}
