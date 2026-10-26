package com.academy.course.parser;

public interface LineRefactor {
    String removeSeparatorEnclosedWhitespaces(String line);
    String removeWhiteSpacesOnEdges(String line);
    String replaceDash(String line);
    String removeSeparatorEnclosedNumbers(String line);

}
