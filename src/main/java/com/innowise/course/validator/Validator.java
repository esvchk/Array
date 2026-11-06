package com.innowise.course.validator;

import com.innowise.course.validator.validatorImpl.ValidationResult;

public interface Validator {

    String ALLOWED_CHARS = "^[0-9\\s,;\\-\\u2013\\u2014]+$";
    String ONE_NUMBER = "\\d";
    String DASH_IS_NOT_BETWEEN_NUMBERS = ".*(^|[^0-9])-($|[^0-9]).*";

    boolean validate (String line, ValidationResult result);
}
