package com.academy.course.validator;

import com.academy.course.validator.validatorImpl.ValidationResult;

public interface Validator {
    void validate (String line, ValidationResult result);
}
