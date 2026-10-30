package com.academy.course.validator.validatorImpl;

import com.academy.course.service.minMaxService.impl.MinMaxServiceImpl;
import com.academy.course.utils.Constants;
import com.academy.course.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DashValidator implements Validator {

    private final Logger logger = LogManager.getLogger(DashValidator.class);
    @Override
    public void validate(String line, ValidationResult result) {
        if (line.matches(DASH_IS_NOT_BETWEEN_NUMBERS)) {
            logger.warn("Wrong place for dash in line{}",line);
            result.addError("Dash in a wrong place in line " + line);
        }
    }
}
