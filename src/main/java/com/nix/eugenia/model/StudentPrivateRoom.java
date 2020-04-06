package com.nix.eugenia.model;

import java.util.List;

public class StudentPrivateRoom implements PrivateRoom {

    private Student student;

    @Override
    public List<Schedule> seeMySchedules() {
        return null;
    }

    @Override
    public Teacher myPersonalInfo() {
        return this.student.getTeacher();
    }




}
