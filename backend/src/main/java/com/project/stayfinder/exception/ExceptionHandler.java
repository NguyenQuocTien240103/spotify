package com.project.stayfinder.exception;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.Objects;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(exception = AppException.class)
    public ResponseEntity<String> handleAppException(AppException exception) {
        return ResponseEntity.status(exception.getError().getCode())
                .body(exception.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(exception = MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidateException(MethodArgumentNotValidException exception) {
        return ResponseEntity.status(exception.getStatusCode()).body(Objects.requireNonNull(exception.getFieldError()).getDefaultMessage());
    }
}
