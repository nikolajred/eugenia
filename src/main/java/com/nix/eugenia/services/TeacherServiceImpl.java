package com.nix.eugenia.services;

import com.nix.eugenia.model.Schedule;
import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.repositories.ScheduleRepository;
import com.nix.eugenia.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final ScheduleRepository scheduleRepository;


    @Override
    public Teacher getTeacher(Long id) {
        return teacherRepository.findById(id).get();
    }


    @Override
    public List<Teacher> getTeacherBySchedule(Schedule startTime) {
        //start.getTime();
        List<Schedule> needSchedule = scheduleRepository.findAll().stream().filter(schedule -> startTime.getStartTime()
                .before(schedule.getStartTime()) || startTime.getStartTime().equals(schedule.getStartTime()))
                .collect(Collectors.toList());

        List<Teacher> needTeachers = teacherRepository.findAll().stream().filter(teacher ->
                teacher.getSchedules().equals(needSchedule)).collect(Collectors.toList());
        return needTeachers;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll().stream().collect(Collectors.toList());
    }


}
