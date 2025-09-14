package com.szentebalint.fullcrudapp.controller.exceptions;

public class BadRequestBodyException extends RuntimeException {
    public BadRequestBodyException(String message) {
        super(message);
    }

    public BadRequestBodyException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestBodyException(Throwable cause) {
        super(cause);
    }
}
