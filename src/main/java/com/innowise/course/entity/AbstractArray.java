package com.innowise.course.entity;

import com.innowise.course.exception.ArrayException;

public abstract class AbstractArray<T> {

    protected int size;
    protected Long id;

    public abstract T get(int index) throws ArrayException;
    public abstract void add(T t) throws ArrayException;
    public abstract void set(int index,T value) throws ArrayException;
    public abstract boolean checkIndex(int index) throws ArrayException;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

}
