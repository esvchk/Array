package com.academy.course.factory;

import com.academy.course.entity.AbstractArray;
import com.academy.course.entity.GenericArray;
import com.academy.course.exception.ArrayException;

public class GenericArrayFactory<T> extends AbstractArrayFactory<T> {
    @Override
    public AbstractArray<T> create(int capacity) throws ArrayException {
        if (capacity == 0) {
            throw new ArrayException("Array cannot be empty" + capacity);
        } else {
            return new GenericArray<>(capacity);
        }

    }

}
