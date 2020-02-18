package com.nix.eugenia.repositories;

import com.nix.eugenia.model.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {

}
