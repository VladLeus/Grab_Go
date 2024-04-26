package com.example.backend.exception;

import java.time.LocalDateTime;

public record ApiException(String message, LocalDateTime time) {
}
