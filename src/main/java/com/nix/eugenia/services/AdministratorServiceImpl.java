package com.nix.eugenia.services;

import com.nix.eugenia.DTO.StudentDTO;
import com.nix.eugenia.exceptions.BadRequestException;
import com.nix.eugenia.exceptions.ResourceNotFoundException;
import com.nix.eugenia.mapper.StudentMapper;
import com.nix.eugenia.mapper.TeacherMapper;
import com.nix.eugenia.model.*;
import com.nix.eugenia.repositories.StudentRepository;
import com.nix.eugenia.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AdministratorServiceImpl implements AdministratorService {

    private final StudentRepository studentRepository;
    private final StudentService studentService;
    private final TeacherRepository teacherRepository;
    private final TeacherService teacherService;
    private final StudentMapper mapper;

    @Autowired
    public AdministratorServiceImpl(StudentRepository studentRepository, StudentService studentService, TeacherRepository teacherRepository, TeacherService teacherService, StudentMapper mapper) {
        this.studentRepository = studentRepository;
        this.studentService = studentService;
        this.teacherRepository = teacherRepository;
        this.teacherService = teacherService;
        this.mapper = mapper;
    }


    @Override
    public List<Teacher> addTeacher() {
        return null;
    }

    @Override
    public List<Teacher> removeTeacher() {
        return null;
    }





    @Override
    public List<Teacher> updateTeacher() {
        return null;
    }

    @Override
    public void setStudentTimetable(Long studentId, List<TimePeriod> lessonTimes) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("This student doesn't exist", studentId));
        Teacher teacher = student.getTeacher();
        if (teacher == null) throw new ResourceNotFoundException("This student doesn`t have a teacher", studentId);
        for (TimePeriod lessonTime : lessonTimes) {
            if (!teacher.isLessonInWorkingTime(lessonTime)) {
                throw new BadRequestException("Lesson time " + lessonTime + " is not teacher`s working time");
            }
        }
        List<Timetable> timetables = new ArrayList<>(student.getTimetables());
        for (Student stud : teacher.getStudents()) {
            for (TimePeriod lessonTime : lessonTimes) {
                if (timetables.isEmpty()) {
                    timetables.add(new Timetable(lessonTime, studentService.getStudentByTimeTable(lessonTime)));
                    continue;
                }
                for (Timetable timetable : stud.getTimetables()) {
                    if (lessonTime.isPeriodsCrosses(timetable.getTimePeriod())) {
                        throw new BadRequestException("Lesson time " + lessonTime + " is not available");
                    }
                    timetables.add(new Timetable(lessonTime, studentService.getStudentByTimeTable(lessonTime)));
                }
            }
        }


        student.setTimetables(timetables);
        studentRepository.save(student);
    }

    @Override
    public void addTeacherToStudent(Long studentId, Long teacherId) {
        Student student = studentRepository.findById(studentId).get();
        student.setTeacher(teacherRepository.findById(teacherId).get());
        studentRepository.save(student);
    }

    @Override
    public void setTeacherSchedule(Long teacherId, List<TimePeriod> workingTimes) {
        if (workingTimes.isEmpty()) throw new BadRequestException("Input working time is empty");
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new ResourceNotFoundException("This teacher doesn't exist", teacherId));
        List<Schedule> schedules = new ArrayList<>(teacher.getSchedules());
        for (TimePeriod workingTime : workingTimes) {
            if (teacher.getSchedules().isEmpty()) {
                schedules.add(new Schedule(workingTime, teacherService.getTeacherBySchedule(workingTime)));
                continue;
            }
            for (Schedule schedule : teacher.getSchedules()) {
                if (workingTime.isPeriodsCrosses(schedule.getTimePeriod())) {
                    throw new BadRequestException("Working time " + workingTime + " is not available");
                }
                schedules.add(new Schedule(workingTime, teacherService.getTeacherBySchedule(workingTime)));
            }
        }

        teacher.setSchedules(schedules);
        teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacherSchedule(Long teacherId, TimePeriod workingTime) {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new ResourceNotFoundException("This teacher doesn't exist", teacherId));
        if (teacher.getSchedules().isEmpty()) {
            throw new ResourceNotFoundException("This teacher doesn't have a schedule", teacherId);
        }
        List<Schedule> schedules = new ArrayList<>(teacher.getSchedules());
        for (Schedule schedule : schedules) {
            if (schedule.getTimePeriod().getStartTime().compareTo(workingTime.getStartTime()) == 0
                    && schedule.getTimePeriod().getFinishTime().compareTo(workingTime.getFinishTime()) == 0) {
                schedules.remove(schedule);
                for (Student student: teacher.getStudents()) {
                    if (student.getTimetables().isEmpty()) continue;
                    List<Timetable> timetables = new ArrayList<>();
                    for (Timetable timetable : student.getTimetables()) {
                        if (!timetable.getTimePeriod().isPeriodIn(schedule.getTimePeriod())){
                            timetables.add(timetable);
                        }
                    }
                    student.setTimetables(timetables);
                    studentRepository.save(student);
                }

            }
            break;
        }
        teacher.setSchedules(schedules);
        teacherRepository.save(teacher);
    }


    public void changeCurrentTeacher(Long studentId, Long teacherId) {
        Student student = studentRepository.findById(studentId).get();
        Teacher teacher = teacherRepository.findById(teacherId).get();
        student.setTeacher(teacher);
        teacher.getStudents().add(student);
        teacherRepository.save(teacher);
    }

    public void addStudent(StudentDTO studentDto) {
        studentRepository.save(mapper.toEntity(studentDto));

    }

    public void deleteStudent(Long studentID) {

        studentRepository.deleteById(studentID);
    }


    public void updateStudentLessons(Long studentId, Long lessonsLeft) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("This student doesn't exist", studentId));

        student.setLessonsLeft((Long) student.getLessonsLeft() + lessonsLeft);

        studentRepository.save(student);
    }



}

