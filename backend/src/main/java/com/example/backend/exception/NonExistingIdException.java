package com.example.backend.exception;

//401
public class NonExistingIdException extends RuntimeException {
    public NonExistingIdException(String message) {
        super(message);
    }
}
