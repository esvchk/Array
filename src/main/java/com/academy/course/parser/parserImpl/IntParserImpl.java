package com.academy.course.parser.parserImpl;

import com.academy.course.exception.ArrayException;
import com.academy.course.parser.IntParser;
import com.academy.course.utils.Constants;
import com.academy.course.validator.charRefactor.Refactor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class IntParserImpl implements IntParser {

    private final Logger logger = LogManager.getLogger(IntParserImpl.class);

    @Override
    public Integer[] parseToInt(String line, Refactor refactor) throws ArrayException {
        if (line == null || line.isBlank()) {
            logger.warn("Empty line, cannot parse");
            throw new ArrayException("Empty Line" + line);
        }
        String newLine = refactor.rebuildLine(line).trim();
        return Arrays.stream(newLine.split(Constants.SEPARATOR))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }
}
