package com.nix.eugenia.services;

import com.nix.eugenia.DTO.StudentDTO;
import com.nix.eugenia.DTO.TeacherDTO;
import com.nix.eugenia.DTO.TimePeriodDTO;
import com.nix.eugenia.exceptions.ResourceNotFoundException;
import com.nix.eugenia.exceptions.TeacherNotFoundException;
import com.nix.eugenia.mapper.StudentMapper;
import com.nix.eugenia.mapper.TeacherMapper;
import com.nix.eugenia.mapper.TimePeriodMapper;
import com.nix.eugenia.model.*;
import com.nix.eugenia.repositories.StudentRepository;
import com.nix.eugenia.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service

public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    private final TimePeriodMapper timePeriodMapper;
    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository, TeacherMapper teacherMapper
            , TimePeriodMapper timePeriodMapper, StudentMapper studentMapper,  StudentRepository studentRepository) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
        this.timePeriodMapper = timePeriodMapper;
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
    }


    @Override
    public TeacherDTO getTeacherById(Long id) {
        return teacherMapper.toDto(teacherRepository.findById(id).orElseThrow(() -> new TeacherNotFoundException(id)));
//        return teacherRepository.findById(id)
//                .orElseThrow(() -> new TeacherNotFoundException(id));
    }

    @Override
    public List<TeacherDTO> getTeacherByStartSchedule(Date startTime) {
        return teacherRepository.findAll().stream().filter(teacher -> teacher.getSchedules()
                .stream().anyMatch(timetable -> timetable.getTimePeriod().getStartTime().equals(startTime))).map(teacherMapper::toDto).collect(Collectors.toList());
    }

//    @Override
//    public List<Teacher> getTeacherByFullSchedule(Schedule lessonTime) {
//        return  teacherRepository.findByPeriod(Timestamp.from(lessonTime.getTimePeriod().getStartTime().toInstant()), Timestamp.from(lessonTime.getTimePeriod().getFinishTime().toInstant()));
//    }

    @Override
    public List<TeacherDTO> getAllTeachers() {
        return teacherRepository.findAll().stream().map(teacherMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<TeacherDTO> getTeacherByName(String name) {
        return teacherRepository.findAllByName(name).stream().map(teacherMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<Teacher> getTeacherBySchedule(TimePeriod timePeriod) {
        return teacherRepository.findAll().stream().filter(teacher -> teacher.getSchedules()
                .stream().anyMatch(schedules -> schedules.getTimePeriod().getId() == timePeriod.getId())).collect(Collectors.toList());
    }

    @Override
    public List<TimePeriodDTO> getTeacherSchedules(Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new ResourceNotFoundException("This teacher doesn't exist", teacherId));
        List<TimePeriod> timePeriods = new ArrayList<>();
        for (Schedule schedule : teacher.getSchedules()) {
            timePeriods.add(schedule.getTimePeriod());
        }
        return timePeriods.stream().map(timePeriodMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Map<TimePeriodDTO, StudentDTO> getTimetableByTeacherSchedule(Long teacherId, TimePeriod lessonTime) {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new ResourceNotFoundException("This teacher doesn't exist", teacherId));
        Map<TimePeriodDTO, StudentDTO> timePeriods = new HashMap<>();
        for (Student student : teacher.getStudents()) {
            for (Timetable timetable : student.getTimetables()) {
                if (timetable.getTimePeriod().isPeriodIn(lessonTime)) {
                    timePeriods.put(timePeriodMapper.toDto(timetable.getTimePeriod()), studentMapper.toDto(student));
                }
            }
        }
        return timePeriods;
    }


    public List<Student> getStudentsByTeacherId(Long teacherId) {
        return teacherRepository.findById(teacherId).get().getStudents();
    }


    @Override
    public String startLesson(Long teacherId, Long studentId,
                              String lessonName, String videoName) {

        Student newStudent = studentRepository.findById(studentId).orElseThrow(() ->
                new ResourceNotFoundException("I'm sorry but there's no student ", studentId));
        newStudent.setVideoLesson(videoName);
        newStudent.setCanJoinLesson(true);
        studentRepository.save(newStudent);
        return videoName + "   " + lessonName;
    }

    @Override
    public String finishLesson(Long studentId) {

        Student newStudent = studentRepository.findById(studentId).orElseThrow(() ->
                new ResourceNotFoundException("I'm sorry but there's no student ", studentId));
        newStudent.setVideoLesson("lesson hasn't been started yet");
        newStudent.setCanJoinLesson(false);
        studentRepository.save(newStudent);
        return "lesson has been stopped";

    }


}
