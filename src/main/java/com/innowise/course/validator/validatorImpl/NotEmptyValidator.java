package com.innowise.course.validator.validatorImpl;

import com.innowise.course.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NotEmptyValidator implements Validator {

    private final Logger logger = LogManager.getLogger(NotEmptyValidator.class);

    @Override
    public boolean validate(String line, ValidationResult result) {
        if (line == null) {
            logger.error("Line is null");
            result.addError("Null line");
        }
        if (line.isBlank()) {
            logger.error("Empty line");
            result.addError("Empty line");
        }
        return result.isValid();
    }
}
