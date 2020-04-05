package com.nix.eugenia.mapper;

import com.nix.eugenia.DTO.TeacherDTO;
import com.nix.eugenia.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper extends AbstractMapper<Teacher, TeacherDTO> {


    @Autowired
    public TeacherMapper() {
        super(Teacher.class, TeacherDTO.class);
    }
}
