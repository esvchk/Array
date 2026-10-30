package com.academy.course.exception;

public class WrongIndexException extends RuntimeException {

    public WrongIndexException(String message) {
        super(message);
    }

    public WrongIndexException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongIndexException(Throwable cause) {
        super(cause);
    }
}
