package com.innowise.course.validator.validatorImpl;

import com.innowise.course.utils.Constants;
import com.innowise.course.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class NumberCharValidator implements Validator {

    private final Logger logger = LogManager.getLogger(NumberCharValidator.class);

    @Override
    public boolean validate(String line, ValidationResult result) {
        String[] chars = line.trim().split(Constants.SEPARATOR);
        for (String symbol : chars){
            if (!symbol.matches(ONE_NUMBER)) {
                logger.error("Line{} contains two sign digit",line);
                result.addError("Invalid symbol " + symbol + " in line " + line);
            }
        }
        return result.isValid();
    }
}
