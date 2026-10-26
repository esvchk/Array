package com.academy.course.parser;

import com.academy.course.utils.Const;

public class LineRefactorImpl implements LineRefactor{


    @Override
    public String removeSeparatorEnclosedWhitespaces(String line) {
        return replaceDash(line.replaceAll(Const.FIND_DASH_ENCLOSED_WHITESPACES," "));
    }

    @Override
    public String removeWhiteSpacesOnEdges(String line) {
        return line.trim();
    }

    @Override
    public String replaceDash(String line) {
        return removeWhiteSpacesOnEdges(line.replace('\u2013', '-')
                .replace('\u2014', '-'));
    }

    @Override
    public String removeSeparatorEnclosedNumbers(String line) {
        return removeSeparatorEnclosedWhitespaces(line.replaceAll
                (Const.FIND_DASH_ENCLOSED_NUMBERS," "));
    }
}
