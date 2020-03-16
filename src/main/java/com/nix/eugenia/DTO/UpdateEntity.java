package com.nix.eugenia.DTO;

import com.nix.eugenia.model.Role;
import com.nix.eugenia.model.Student;
import com.nix.eugenia.model.Teacher;
import com.nix.eugenia.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@Data
public class UpdateEntity {
    private Student student;

    private Teacher teacher;
    private Role role;
    private User user;

}
