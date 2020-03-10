package com.nix.eugenia.repositories;

import com.nix.eugenia.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("SELECT t FROM Teacher t JOIN t.schedules s WHERE s.startTime >= :startTime ORDER BY s.startTime")
    List<Teacher> findByStartTime(Timestamp startTime);

    List<Teacher> findAllByName(String name);

}



