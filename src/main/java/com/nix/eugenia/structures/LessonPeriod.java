package com.nix.eugenia.structures;

import com.nix.eugenia.model.Student;
import com.nix.eugenia.repositories.StudentRepository;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class LessonPeriod {


    private final Date startLesson;
    private final Date endLesson;





}
