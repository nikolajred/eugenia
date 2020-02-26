package com.nix.eugenia.services;

import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.joda.time.Interval;
import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService{

    private final TeacherRepository teacherRepository;


    @Override
    public Teacher getTeacher(Long id) {
        return teacherRepository.findById(id).get();
    }

    @Override
    public List<Teacher> getTeacherByInterval(LocalDateTime start, LocalDateTime finish) {
        return null;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll().stream().collect(Collectors.toList());
    }





}
