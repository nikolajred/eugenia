package com.nix.eugenia.repositories;

import com.nix.eugenia.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT '*' FROM Student t JOIN t.timetables s WHERE s.startLesson = :startTime and s.endLesson = :endTime ORDER BY s.startLesson, s.endLesson")
    List<Student> findByLessonTime(Timestamp startTime, Timestamp endTime);

}
