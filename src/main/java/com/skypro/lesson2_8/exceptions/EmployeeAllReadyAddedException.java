package com.skypro.lesson2_8.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeAllReadyAddedException extends RuntimeException {
    public EmployeeAllReadyAddedException() {
    }

    public EmployeeAllReadyAddedException(String message) {
        super(message);
    }

    public EmployeeAllReadyAddedException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeAllReadyAddedException(Throwable cause) {
        super(cause);
    }

    public EmployeeAllReadyAddedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
