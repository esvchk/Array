package com.academy.course.validator.validatorImpl;

import com.academy.course.service.minMaxService.impl.MinMaxServiceImpl;
import com.academy.course.utils.Constants;
import com.academy.course.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CharsValidator implements Validator {

    private final Logger logger = LogManager.getLogger(CharsValidator.class);

    @Override
    public void validate(String line, ValidationResult result) {
        if (!line.matches(ALLOWED_CHARS)) {
            logger.warn("Line {} contains banned chars",line);
            result.addError("Line contains banned chars");
        }
    }
}
