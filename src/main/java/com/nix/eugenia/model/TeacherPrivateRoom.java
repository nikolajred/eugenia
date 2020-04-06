package com.nix.eugenia.model;

import java.util.List;

public class TeacherPrivateRoom implements PrivateRoom {
    private Teacher teacher;


    @Override
    public List<Schedule> seeMySchedules() {
        return this.teacher.getSchedules();
    }

    @Override
    public Teacher myPersonalInfo() {
        return this.teacher;
    }

}


