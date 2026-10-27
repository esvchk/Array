package com.academy.course.validator;

import com.academy.course.utils.Constants;

public class CharsValidator implements Validator {

    @Override
    public void validate(String line, ValidationResult result) {
        if (!line.matches(Constants.ALLOWED_CHARS)) {
            result.addError("Line contains banned chars");
        }
    }
}
