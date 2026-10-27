package com.academy.course.validator;

import com.academy.course.utils.Constants;

public class CharRefactor implements Refactor{

    public String refactor(String line){
        String s = line.replace('–', '-').replace('—', '-');
        s = s.replaceAll(Constants.DASH_ENCLOSED_WHITESPACES,Constants.WHITESPACE);
        s = s.replaceAll(Constants.DASH_ENCLOSED_NUMBERS,Constants.WHITESPACE);
        return s;
    }
}
