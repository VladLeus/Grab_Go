package com.example.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public record ControllerExceptionHandler() {


    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<ApiException> handleBadRequestException(BadRequestException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ApiException(e.getMessage(), LocalDateTime.now())
        );
    }

    @ExceptionHandler({NonExistingIdException.class})
    public ResponseEntity<ApiException> handleNonExistingIdException(NonExistingIdException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                new ApiException(e.getMessage(), LocalDateTime.now())
        );
    }
}
