package com.innowise.course.validator.charRefactor;

import com.innowise.course.exception.ArrayException;

public interface Refactor {

    String DASH_ENCLOSED_WHITESPACES = "(?<=\\d)\\s+-\\s+(?=\\d)";
    String DASH_ENCLOSED_NUMBERS = "(?<=\\d)-(?=\\d)";
    String WHITESPACE = " ";

    String rebuildLine(String fileLine) throws ArrayException;
}
