package com.academy.course.validator.charRefactor.refactorImpl;

import com.academy.course.utils.Constants;
import com.academy.course.validator.charRefactor.Refactor;

public class CharRefactor implements Refactor {

    public String rebuildLine(String line){
        String s = line.replace('–', '-').replace('—', '-');
        s = s.replaceAll(DASH_ENCLOSED_WHITESPACES,WHITESPACE);
        s = s.replaceAll(DASH_ENCLOSED_NUMBERS,WHITESPACE);
        return s;
    }
}
