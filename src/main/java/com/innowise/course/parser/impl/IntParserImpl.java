package com.innowise.course.parser.impl;

import com.innowise.course.exception.ArrayException;
import com.innowise.course.parser.IntParser;
import com.innowise.course.utils.Constants;
import com.innowise.course.validator.charRefactor.Refactor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class IntParserImpl implements IntParser {

    private final Logger logger = LogManager.getLogger(IntParserImpl.class);

    @Override
    public Integer[] parseToInt(String line, Refactor refactor) throws ArrayException {
        if (line == null || line.isBlank()) {
            logger.error("Empty line, cannot parse");
            throw new ArrayException("Empty Line" + line);
        }
        String newLine = refactor.rebuildLine(line).trim();
        return Arrays.stream(newLine.split(Constants.SEPARATOR))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }
}
