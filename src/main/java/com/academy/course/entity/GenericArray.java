package com.academy.course.entity;

import com.academy.course.exception.ArrayException;
import com.academy.course.utils.Constants;

import java.util.Arrays;
import java.util.Objects;

public class GenericArray<T> extends AbstractArray<T> {

    private Object[] objArray;
    private int capacity;


    public GenericArray() {
        this(Constants.DEFAULT_ARRAY_CAPACITY);
    }

    public GenericArray(int capacity) {
        this.capacity = capacity;
        this.objArray = new Object[capacity];
    }

    @Override
    public T get(int index) throws ArrayException {
        if (index < 0 || index >= size) {
            throw new ArrayException("index=" + index + ",size=" + size);
        }
        return (T) objArray[index];
    }


    @Override
    public void add(T value) throws ArrayException {
        if (value == null) {
            throw new ArrayException("Empty array " + value);
        }
        if (size == capacity){
            grow();
        }
        objArray[size++] = value;
    }

    private void grow() {
        capacity = capacity * 2;
        objArray = Arrays.copyOf(objArray, capacity);
    }

    @Override
    public void set(int index, T value) throws ArrayException {
        if (index < 0 || index >= size) {
            throw new ArrayException("index=" + index + ",size=" + size);
        }
        objArray[index] = value;
    }

    @Override
    public String toString() {
        return new StringBuilder("Generic array ")
                .append(Arrays.toString(Arrays.copyOf(objArray, size))).toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        GenericArray<?> that = (GenericArray<?>) object;
        return capacity == that.capacity && Objects.deepEquals(objArray, that.objArray);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(objArray), capacity);
    }
}
