package com.nix.eugenia.services;

import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.repositories.ScheduleRepository;
import com.nix.eugenia.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService{

    private final TeacherRepository teacherRepository;
    private final ScheduleRepository scheduleRepository;


    @Override
    public Teacher getTeacher(Long id) {
        return teacherRepository.findById(id).get();
    }

    @Override
    public List<Teacher> getTeacherByInterval(Calendar start, Calendar finish) {
        scheduleRepository.findAll().stream().filter(schedule->start.before(start)).collect(Collectors.toList());
        return null;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll().stream().collect(Collectors.toList());
    }





}
