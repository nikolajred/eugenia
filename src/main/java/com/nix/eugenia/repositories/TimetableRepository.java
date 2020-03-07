package com.nix.eugenia.repositories;

import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.model.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TimetableRepository extends JpaRepository<Timetable, Long> {

//    @Query("select timetable from student where student.teacher = :id")
//    Timetable getTeacherTimetable(@Param("id") long id);

}