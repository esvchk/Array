package com.academy.course.parser.parserImpl;

import com.academy.course.parser.Parser;
import com.academy.course.utils.Constants;
import com.academy.course.validator.charRefactor.Refactor;
import com.academy.course.validator.charRefactor.refactorImpl.CharRefactor;

import java.util.Arrays;

public class IntParser implements Parser {


    @Override
    public Integer[] parseToInt(String line, Refactor refactor) {
        String newLine = refactor.rebuildLine(line).trim();
        return Arrays.stream(newLine.split(Constants.SEPARATOR))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }
}
