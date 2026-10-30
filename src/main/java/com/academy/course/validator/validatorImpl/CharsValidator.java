package com.academy.course.validator.validatorImpl;

import com.academy.course.utils.Constants;
import com.academy.course.validator.Validator;

public class CharsValidator implements Validator {

    @Override
    public void validate(String line, ValidationResult result) {
        if (!line.matches(ALLOWED_CHARS)) {
            result.addError("Line contains banned chars");
        }
    }
}
