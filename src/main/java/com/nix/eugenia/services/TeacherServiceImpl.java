package com.nix.eugenia.services;

import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.model.Timetable;
import com.nix.eugenia.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

//    @Override
//    public Teacher getTeacherTimetable(String name) {
//        return null;
//    }
}
