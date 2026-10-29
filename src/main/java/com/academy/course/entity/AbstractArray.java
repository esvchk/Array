package com.academy.course.entity;

public abstract class AbstractArray<T> {

    protected int size;

    public abstract T get(int index);
    public abstract void add(T t);
    public abstract void set(int index,T value);

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

}
