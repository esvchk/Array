package com.academy.course.factory;

import com.academy.course.entity.AbstractArray;
import com.academy.course.entity.GenericArray;

public class GenericArrayFactory<T> extends ArrayFactory<T>{
    @Override
    public AbstractArray<T> create(int capacity) {
        return new GenericArray<>(capacity);
    }

}
