package com.nix.eugenia.repositories;

import com.nix.eugenia.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
