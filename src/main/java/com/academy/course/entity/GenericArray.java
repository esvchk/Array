package com.academy.course.entity;

import com.academy.course.utils.Const;

import java.util.Arrays;

public class GenericArray<T> extends AbstractArray<T>{

    private Object[] objArray;
    private int capacity;


    public GenericArray() {
        this(Const.DEFAULT_ARRAY_CAPACITY);
    }

    public GenericArray(int capacity) {
        this.capacity = capacity;
        this.objArray = new Object[capacity];
    }


    @Override
    public T get(int index) {
        return (T)objArray[index];
    }


    @Override
    public void add(T value) {
        objArray[size++] = value;
    }

    @Override
    public String toString() {
        return "GenericArray{" +
                "objArray=" + Arrays.toString(objArray) +
                ", capacity=" + capacity +
                '}';
    }
}
