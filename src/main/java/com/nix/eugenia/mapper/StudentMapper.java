package com.nix.eugenia.mapper;

import com.nix.eugenia.DTO.StudentDTO;
import com.nix.eugenia.model.Student;
import com.nix.eugenia.repositories.StudentRepository;
import com.nix.eugenia.repositories.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class StudentMapper extends AbstractMapper<Student, StudentDTO> {

    private final ModelMapper mapper;
    private final TeacherRepository teacherRepository;

    @Autowired
    public StudentMapper(ModelMapper mapper, TeacherRepository teacherRepository) {
        super(Student.class, StudentDTO.class);
        this.mapper = mapper;
        this.teacherRepository = teacherRepository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Student.class, StudentDTO.class)
                .addMappings(m -> m.skip(StudentDTO::setTeacherId)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(StudentDTO.class, Student.class)
                .addMappings(m -> m.skip(Student::setTeacher)).setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFields(Student source, StudentDTO destination) {
        destination.setTeacherId(getId(source));
    }

    private Long getId(Student source) {
        return Objects.isNull(source) || Objects.isNull(source.getTeacher()) ? null : source.getTeacher().getId();
    }

    @Override
    void mapSpecificFields(StudentDTO source, Student destination) {
        if (source.getTeacherId() != null)
        destination.setTeacher(teacherRepository.findById(source.getTeacherId()).orElse(null));
        else destination.setTeacher(null);
    }
}
