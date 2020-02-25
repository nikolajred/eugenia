package com.nix.eugenia.repositories;

import com.nix.eugenia.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

//    @Query("select student from teacher ")
//    List<Student> getStudentsByTeacher(@Param("id") long id);

}
