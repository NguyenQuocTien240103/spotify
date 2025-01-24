package com.project.stayfinder.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@AllArgsConstructor
public enum Error {
    UNCATEGORIZED_EXCEPTION("Uncategorized exception", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND("User not found", HttpStatus.NOT_FOUND),
    EMAIL_EXISTED("Email already exists", HttpStatus.CONFLICT)
    ;
    private final String message;
    private final HttpStatusCode code;
}
