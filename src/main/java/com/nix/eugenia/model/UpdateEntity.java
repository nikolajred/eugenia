package com.nix.eugenia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@Setter
@AllArgsConstructor

public class UpdateEntity {

    private Long teacherId;
    private Long studentId;


}
