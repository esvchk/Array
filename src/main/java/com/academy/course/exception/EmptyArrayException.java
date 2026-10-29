package com.academy.course.exception;

public class EmptyArrayException extends RuntimeException {
    public EmptyArrayException(String message) {
        super(message);
    }

    public EmptyArrayException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyArrayException(Throwable cause) {
        super(cause);
    }
}
