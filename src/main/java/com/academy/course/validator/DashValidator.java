package com.academy.course.validator;

import com.academy.course.utils.Constants;

public class DashValidator implements Validator{
    @Override
    public void validate(String line, ValidationResult result) {
        if (line.matches(Constants.DASH_IS_NOT_BETWEEN_NUMBERS)) {
            result.addError("Dash in a wrong place in line " + line);
        }
    }
}
