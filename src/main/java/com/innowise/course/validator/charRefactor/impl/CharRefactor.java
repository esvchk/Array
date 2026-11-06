package com.innowise.course.validator.charRefactor.impl;

import com.innowise.course.validator.charRefactor.Refactor;

public class CharRefactor implements Refactor {

    public String rebuildLine(String line){
        String s = line.replace('–', '-').replace('—', '-');
        s = s.replaceAll(DASH_ENCLOSED_WHITESPACES,WHITESPACE);
        s = s.replaceAll(DASH_ENCLOSED_NUMBERS,WHITESPACE);
        return s;
    }
}
