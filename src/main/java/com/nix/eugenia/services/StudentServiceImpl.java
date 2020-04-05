package com.nix.eugenia.services;

import com.nix.eugenia.DTO.StudentDTO;
import com.nix.eugenia.exceptions.ResourceNotFoundException;
import com.nix.eugenia.mapper.StudentMapper;
import com.nix.eugenia.model.Student;
import com.nix.eugenia.model.TimePeriod;
import com.nix.eugenia.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper mapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper mapper) {
        this.studentRepository = studentRepository;
        this.mapper = mapper;
    }

    @Override
    public StudentDTO getStudent(Long id) {
        return mapper.toDto(studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("I'm sorry but there's no student ", id)));
//        return studentRepository.findById(id).orElseThrow(()->
//                new ResourceNotFoundException("I'm sorry but there's no student ", id));
    }
    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

//    @Override
//    public List<Student> getStudentsByTimeTable(TimePeriod lessonPeriod) {
//        return  studentRepository.findByLessonTime(Timestamp.from(lessonPeriod.getStartTime().toInstant()), Timestamp.from(lessonPeriod.getFinishTime().toInstant()));
//    }

    public List<Student> getStudentByTimeTable(TimePeriod timePeriod){
        return studentRepository.findAll().stream().filter(stud -> stud.getTimetables()
                .stream().anyMatch(timetable -> timetable.getTimePeriod().equals(timePeriod))).collect(Collectors.toList());
    }
}