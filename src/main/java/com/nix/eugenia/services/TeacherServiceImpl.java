package com.nix.eugenia.services;

import com.nix.eugenia.exceptions.TeacherNotFoundException;
import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

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
