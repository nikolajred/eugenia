package com.nix.eugenia.services;

import com.nix.eugenia.model.Teacher;

import java.util.List;

public interface AdministratorService {


    public List<Teacher> addTeacher();
    public List<Teacher> removeTeacher();
    public List<Teacher> updateTeacher();


}
