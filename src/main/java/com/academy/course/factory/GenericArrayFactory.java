package com.academy.course.factory;

import com.academy.course.entity.AbstractArray;
import com.academy.course.entity.GenericArray;
import com.academy.course.exception.ArrayException;
import com.academy.course.parser.parserImpl.IntParserImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GenericArrayFactory<T> extends AbstractArrayFactory<T> {

    private final Logger logger = LogManager.getLogger(GenericArrayFactory.class);
    @Override
    public AbstractArray<T> create(int capacity) throws ArrayException {
        if (capacity == 0) {
            logger.warn("Impossible create array with capacity{}" ,capacity);
            throw new ArrayException("Array cannot be empty" + capacity);
        } else {
            return new GenericArray<>(capacity);
        }

    }

}
