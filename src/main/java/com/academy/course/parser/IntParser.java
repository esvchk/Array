package com.academy.course.parser;

import com.academy.course.validator.charRefactor.Refactor;

public interface IntParser {
    Integer[] parseToInt(String line, Refactor refactor);
}
