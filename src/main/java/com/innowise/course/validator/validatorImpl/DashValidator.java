package com.innowise.course.validator.validatorImpl;

import com.innowise.course.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DashValidator implements Validator {

    private final Logger logger = LogManager.getLogger(DashValidator.class);
    @Override
    public boolean validate(String line, ValidationResult result) {
        if (line.matches(DASH_IS_NOT_BETWEEN_NUMBERS)) {
            logger.error("Wrong place for dash in line{}",line);
            result.addError("Dash in a wrong place in line " + line);
        }
        return result.isValid();
    }
}
