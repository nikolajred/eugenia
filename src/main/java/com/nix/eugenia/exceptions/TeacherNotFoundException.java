package com.nix.eugenia.exceptions;

public class TeacherNotFoundException extends RuntimeException {

    TeacherNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
