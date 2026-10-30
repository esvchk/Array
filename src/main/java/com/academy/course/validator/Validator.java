package com.academy.course.validator;

import com.academy.course.validator.validatorImpl.ValidationResult;

public interface Validator {

    static final String ALLOWED_CHARS = "^[0-9\\s,;\\-\\u2013\\u2014]+$";
    static final String ONE_NUMBER = "\\d";
    static final String DASH_IS_NOT_BETWEEN_NUMBERS = ".*(^|[^0-9])-($|[^0-9]).*";

    void validate (String line, ValidationResult result);
}
