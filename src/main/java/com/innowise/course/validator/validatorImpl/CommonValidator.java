package com.innowise.course.validator.validatorImpl;

import com.innowise.course.exception.ArrayException;
import com.innowise.course.validator.Validator;
import com.innowise.course.validator.charRefactor.Refactor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CommonValidator {

    private final Logger logger = LogManager.getLogger(CommonValidator.class);

    private final Refactor refactor;
    private final List<Validator> sourceValidators;
    private final List<Validator> newLineValidators;



    public CommonValidator(Refactor refactor, List<Validator> sourceValidators, List<Validator> newLineValidators) {
        this.refactor = refactor;
        this.sourceValidators = sourceValidators;
        this.newLineValidators = newLineValidators;
    }

    public ValidationResult validationResult(String line) throws ArrayException {

        ValidationResult validationResult = new ValidationResult();

        for (Validator v : sourceValidators) v.validate(line,validationResult);

        String newLine = refactor.rebuildLine(line);

        for (Validator v : newLineValidators) v.validate(newLine,validationResult);

        logger.info("Validation result{}",validationResult);

        return validationResult;
    }
}
