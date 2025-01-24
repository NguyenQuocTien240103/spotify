package com.project.stayfinder.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppException extends RuntimeException {
    private Error error;

    public AppException(Error error) {
        super(error.getMessage());
        this.error = error;
    }
}
