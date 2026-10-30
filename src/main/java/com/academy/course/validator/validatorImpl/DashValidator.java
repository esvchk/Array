package com.academy.course.validator.validatorImpl;

import com.academy.course.utils.Constants;
import com.academy.course.validator.Validator;

public class DashValidator implements Validator {
    @Override
    public void validate(String line, ValidationResult result) {
        if (line.matches(DASH_IS_NOT_BETWEEN_NUMBERS)) {
            result.addError("Dash in a wrong place in line " + line);
        }
    }
}
