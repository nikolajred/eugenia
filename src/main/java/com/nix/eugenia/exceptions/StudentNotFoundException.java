package com.nix.eugenia.exceptions;

public class StudentNotFoundException extends RuntimeException {

    StudentNotFoundException(Long id) {
        super("Could not find student " + id + "Please go back and try again");
    }
}
