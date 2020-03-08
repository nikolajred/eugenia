package com.nix.eugenia.services;

import com.nix.eugenia.model.Schedule;
import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.repositories.ScheduleRepository;
import com.nix.eugenia.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final ScheduleRepository scheduleRepository;


    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).get();
    }

    @Override
    public List<Teacher> getTeacherBySchedule(Date startTime) {
        return  teacherRepository.findAllTeachersWithSchedulStartTimeBefore(startTime).stream().collect(Collectors.toList());
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll().stream().collect(Collectors.toList());
    }

    @Override
    public List<Teacher> getTeacherByName(String name) {
        return teacherRepository.findAllTeacherByName(name).stream().collect(Collectors.toList());
    }
}
