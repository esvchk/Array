package com.academy.course.parser;

import com.academy.course.validator.CharRefactor;

public interface Parser {
    Integer[] parseToInt(String line, CharRefactor refactor);
}
