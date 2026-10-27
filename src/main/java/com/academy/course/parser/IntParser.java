package com.academy.course.parser;

import com.academy.course.utils.Constants;
import com.academy.course.validator.CharRefactor;

import java.util.Arrays;

public class IntParser implements Parser{


    @Override
    public Integer[] parseToInt(String line, CharRefactor refactor) {
        String newLine = refactor.refactor(line).trim();
        return Arrays.stream(newLine.split(Constants.SEPARATOR))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }
}
