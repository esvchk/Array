package com.academy.course.parser;

import com.academy.course.validator.charRefactor.Refactor;
import com.academy.course.validator.charRefactor.refactorImpl.CharRefactor;

public interface Parser {
    Integer[] parseToInt(String line, Refactor refactor);
}
