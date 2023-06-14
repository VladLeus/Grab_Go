package com.example.backend.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public record ControllerExceptionHandler() {


    @ExceptionHandler({NonExistingIdException.class, BadRequestException.class})
    public ResponseEntity<ApiException> handleValidationException(HttpServletRequest request, NonExistingIdException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ApiException(e.getMessage(), LocalDateTime.now())
        );
    }
}
