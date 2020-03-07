package com.nix.eugenia.repositories;

import com.nix.eugenia.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Modifying
    @Query("SELECT t FROM Teacher t INNER JOIN t.schedules s WHERE s.startTime >= :startTime")
    List<Teacher> findAllTeachersWithSchedulStartTimeBefore(
            @Param("startTime") Date startTime);

}


