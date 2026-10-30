package com.academy.course.validator.validatorImpl;

import com.academy.course.service.minMaxService.impl.MinMaxServiceImpl;
import com.academy.course.utils.Constants;
import com.academy.course.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class NumberCharValidator implements Validator {

    private final Logger logger = LogManager.getLogger(NumberCharValidator.class);

    @Override
    public void validate(String line, ValidationResult result) {
        String[] chars = line.trim().split(Constants.SEPARATOR);
        for (String symbol : chars){
            if (!symbol.matches(ONE_NUMBER)) {
                logger.warn("Line{} contains two sign digit",line);
                result.addError("Invalid symbol " + symbol + " in line " + line);
            }
        }
    }
}
