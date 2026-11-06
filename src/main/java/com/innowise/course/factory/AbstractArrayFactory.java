package com.innowise.course.factory;

import com.innowise.course.entity.AbstractArray;
import com.innowise.course.exception.ArrayException;
import com.innowise.course.utils.Constants;

public abstract class AbstractArrayFactory<T> {

    public abstract AbstractArray<T> create(int capacity) throws ArrayException;

    public AbstractArray<T> fill (T[] values) throws ArrayException {
        AbstractArray<T> arr = create(Math.max(values.length, Constants.DEFAULT_ARRAY_CAPACITY));
        for (T t : values) arr.add(t);
        return arr;
    }

}
