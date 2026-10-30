package com.academy.course.validator.charRefactor;

public interface Refactor {

    static final String DASH_ENCLOSED_WHITESPACES = "(?<=\\d)\\s+-\\s+(?=\\d)";
    static final String DASH_ENCLOSED_NUMBERS = "(?<=\\d)-(?=\\d)";
    static final String WHITESPACE = " ";

    String rebuildLine(String fileLine);
}
