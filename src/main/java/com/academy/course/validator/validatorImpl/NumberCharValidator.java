package com.academy.course.validator.validatorImpl;

import com.academy.course.utils.Constants;
import com.academy.course.validator.Validator;


public class NumberCharValidator implements Validator {
    @Override
    public void validate(String line, ValidationResult result) {
        String[] chars = line.trim().split(Constants.SEPARATOR);
        for (String symbol : chars){
            if (!symbol.matches(Constants.ONE_NUMBER)) {
                result.addError("Invalid symbol " + symbol + " in line " + line);
            }
        }
    }
}
