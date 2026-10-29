package com.academy.course.validator.validatorImpl;

import com.academy.course.validator.Validator;
import com.academy.course.validator.charRefactor.Refactor;
import com.academy.course.validator.charRefactor.refactorImpl.CharRefactor;

import java.util.ArrayList;
import java.util.List;

public class CommonValidator {

    private final Refactor refactor;
    private final List<Validator> sourceValidators;
    private final List<Validator> newLineValidators;

    public CommonValidator(Refactor refactor, List<Validator> sourceValidators, List<Validator> newLineValidators) {
        this.refactor = refactor;
        this.sourceValidators = sourceValidators;
        this.newLineValidators = newLineValidators;
    }

    public ValidationResult validationResult(String line){


        ValidationResult validationResult = new ValidationResult();

        for (Validator v : sourceValidators) v.validate(line,validationResult);

        String newLine = refactor.rebuildLine(line);

        for (Validator v : newLineValidators) v.validate(newLine,validationResult);

        return validationResult;
    }
}
