package com.nix.eugenia.services;

import com.nix.eugenia.model.Schedul;
import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.repositories.SchedulRepository;
import com.nix.eugenia.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.joda.time.Interval;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService{

    private final TeacherRepository teacherRepository;
    private final SchedulRepository schedulRepository;

    @Override
    public Teacher getTeacher(Long id) {
        return teacherRepository.findById(id).get();
    }

    @Override
    public List<Teacher> getTeacherByInterval(Interval interval) {
        return null;
    }

   /* @Override
    public List<Teacher> getTeacherByInterval(Interval interval) {
        List<Teacher> teachers = teacherRepository.findAll();
        List<Schedul> schedul = schedulRepository.findAll();
        List<Teacher> TeachersByInterval = new ArrayList<>();
        for (Teacher teacher : teachers) {
            for (Schedul schedules : schedul) {
                Interval NewInterval = new Interval(schedul.getInterval());
                if(interval.overlaps(NewInterval)){
                    TeachersByInterval.add(teacher);
                }
            }
        }
        return TeachersByInterval;
    }*/

}
