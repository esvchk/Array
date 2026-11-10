package com.innowise.course.factory;

import com.innowise.course.entity.AbstractArray;
import com.innowise.course.entity.GenericArray;
import com.innowise.course.exception.ArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GenericArrayFactory extends AbstractArrayFactory<Number> {

    private final Logger logger = LogManager.getLogger(GenericArrayFactory.class);
    @Override
    public AbstractArray<Number> create(int capacity) throws ArrayException {
        if (capacity == 0) {
            logger.error("Impossible create array with capacity{}" ,capacity);
            throw new ArrayException("Array cannot be empty" + capacity);
        } else {
            return new GenericArray(capacity);
        }

    }

}
