package com.academy.course.validator;

public class NotEmptyValidator implements Validator{


    @Override
    public void validate(String line, ValidationResult result) {
        if (line == null) {
            result.addError("Null line");
        }
        if (line.isBlank()) {
            result.addError("Empty line");
        }
    }
}
