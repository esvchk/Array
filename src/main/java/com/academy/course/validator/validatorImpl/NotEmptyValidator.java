package com.academy.course.validator.validatorImpl;

import com.academy.course.service.minMaxService.impl.MinMaxServiceImpl;
import com.academy.course.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NotEmptyValidator implements Validator {

    private final Logger logger = LogManager.getLogger(NotEmptyValidator.class);

    @Override
    public void validate(String line, ValidationResult result) {
        if (line == null) {
            logger.warn("Line is null");
            result.addError("Null line");
        }
        if (line.isBlank()) {
            logger.warn("Empty line");
            result.addError("Empty line");
        }
    }
}
