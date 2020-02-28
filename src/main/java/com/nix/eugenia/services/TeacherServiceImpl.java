package com.nix.eugenia.services;

import com.nix.eugenia.model.DayOfWeek;
import com.nix.eugenia.model.Student;
import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService{

    private final TeacherRepository teacherRepository;

    @Override
    public Teacher getTeacher(Long id) {
        return teacherRepository.findById(id).get();
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }


    @Override
    public List<Teacher> getTeacherByTimeAndDay(DayOfWeek dayOfWeek, String workDay) {

       //пометил NULL чтоб компилилось
        Example<Teacher> sExample = null;
        // пометил NULL чтоб компилилось
        return null;//teacherRepository.findAll(sExample);
    }
}
