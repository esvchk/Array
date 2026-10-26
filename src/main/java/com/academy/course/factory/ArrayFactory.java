package com.academy.course.factory;

import com.academy.course.entity.AbstractArray;
import com.academy.course.utils.Const;

public abstract class ArrayFactory<T> {
    public abstract AbstractArray<T> create(int capacity);

    public AbstractArray<T> fill (T[] values){
        AbstractArray<T> arr = create(Const.DEFAULT_ARRAY_CAPACITY);
        for (T t : values) arr.add(t);
        return arr;
    }

}
