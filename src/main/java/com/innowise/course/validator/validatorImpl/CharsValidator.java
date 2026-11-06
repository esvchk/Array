package com.innowise.course.validator.validatorImpl;

import com.innowise.course.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CharsValidator implements Validator {

    private final Logger logger = LogManager.getLogger(CharsValidator.class);

    @Override
    public boolean validate(String line, ValidationResult result) {
        if (!line.matches(ALLOWED_CHARS)) {
            logger.error("Line {} contains banned chars",line);
            result.addError("Line contains banned chars");
        }
        return result.isValid();
    }
}
