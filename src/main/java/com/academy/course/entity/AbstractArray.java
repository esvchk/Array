package com.academy.course.entity;

import com.academy.course.exception.ArrayException;

public abstract class AbstractArray<T> {

    protected int size;

    public abstract T get(int index) throws ArrayException;
    public abstract void add(T t) throws ArrayException;
    public abstract void set(int index,T value) throws ArrayException;

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

}
