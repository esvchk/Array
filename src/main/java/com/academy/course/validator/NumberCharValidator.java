package com.academy.course.validator;

import com.academy.course.utils.Constants;

public class NumberCharValidator implements Validator{
    @Override
    public void validate(String line, ValidationResult result) {
        String[] chars = Constants.SEPARATOR.split(line.trim());
        for (String symbol : chars ){
            if (!line.matches(Constants.POSITIVE_ONE_NUMBER)) {
                result.addError("Invalid symbol " + symbol + " in line " + line);
            }
        }
    }
}
