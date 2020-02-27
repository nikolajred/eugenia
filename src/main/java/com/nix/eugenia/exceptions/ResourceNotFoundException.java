package com.nix.eugenia.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message, Long id) {
        super(message+" " + id + " Please go back and try again");
    }
}
