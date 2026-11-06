package com.innowise.course.parser;

import com.innowise.course.exception.ArrayException;
import com.innowise.course.validator.charRefactor.Refactor;

public interface IntParser {

    Integer[] parseToInt(String line, Refactor refactor) throws ArrayException;
}
