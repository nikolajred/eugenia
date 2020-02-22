package com.nix.eugenia.exceptions;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(Long id) {
        super("Could not find student " + id + " Please go back and try again");
    }
}
