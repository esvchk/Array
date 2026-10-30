package com.academy.course.validator.charRefactor.impl;

import com.academy.course.exception.ArrayException;
import com.academy.course.validator.charRefactor.Refactor;

public class CharRefactor implements Refactor {

    public String rebuildLine(String line) throws ArrayException {
        if (line == null || line.isBlank()) {
            throw new ArrayException("Empty line");
        }
        String s = line.replace('–', '-').replace('—', '-');
        s = s.replaceAll(DASH_ENCLOSED_WHITESPACES,WHITESPACE);
        s = s.replaceAll(DASH_ENCLOSED_NUMBERS,WHITESPACE);
        return s;
    }
}
