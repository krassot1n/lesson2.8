package com.skypro.lesson2_8.exceptions;

public class FullMapException extends RuntimeException{
    public FullMapException() {
    }

    public FullMapException(String message) {
        super(message);
    }

    public FullMapException(String message, Throwable cause) {
        super(message, cause);
    }

    public FullMapException(Throwable cause) {
        super(cause);
    }

    public FullMapException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
