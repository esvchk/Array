package com.academy.course.validator;

import java.util.ArrayList;
import java.util.List;

public class CommonValidator {
    private final CharRefactor charRefactor = new CharRefactor();
    private final List<Validator> sourceValidators = new ArrayList<>();
    private final List<Validator> newLineValidators = new ArrayList<>();

    public CommonValidator() {
        sourceValidators.add(new NotEmptyValidator());
        sourceValidators.add(new CharsValidator());

        newLineValidators.add(new DashValidator());
        newLineValidators.add(new NumberCharValidator());
    }

    public ValidationResult validationResult(String line){
        ValidationResult validationResult = new ValidationResult();

        for (Validator v : sourceValidators) v.validate(line,validationResult);

        String newLine = charRefactor.refactor(line);

        for (Validator v : newLineValidators) v.validate(newLine,validationResult);

        return validationResult;
    }
}
