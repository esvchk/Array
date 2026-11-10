package com.innowise.course.entity;

import com.innowise.course.exception.ArrayException;
import com.innowise.course.utils.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Objects;

public class GenericArray extends AbstractArray<Number> {

    private final Logger logger = LogManager.getLogger(GenericArray.class);

    private Number[] numberArray;
    private int capacity;
    private Long id;


    public GenericArray() {
        this(Constants.DEFAULT_ARRAY_CAPACITY);
    }

    public GenericArray(int capacity) {
        this.capacity = capacity;
        this.numberArray = new Number[capacity];
    }

    @Override
    public Number get(int index) throws ArrayException {
        checkIndex(index);
        return numberArray[index];
    }


    @Override
    public void add(Number value) throws ArrayException {
        if (value == null) {
            logger.error("Cannot create array with value {}", value);
            throw new ArrayException("Empty array " + value);
        }
        if (size == capacity) {
            grow();
        }
        numberArray[size++] = value;
    }

    private void grow() {
        capacity = capacity * 2;
        logger.info("Expanding array");
        numberArray = Arrays.copyOf(numberArray, capacity);
    }

    @Override
    public void set(int index, Number value) throws ArrayException {
        checkIndex(index);
        numberArray[index] = value;
    }

    @Override
    public boolean checkIndex(int index) throws ArrayException {
        if (index < 0 || index >= size) {
            logger.error("Wrong index{}", index);
            throw new ArrayException("Wrong index" + index);
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return new StringBuilder("Generic array ")
                .append(Arrays.toString(Arrays.copyOf(numberArray, size))).toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        GenericArray that = (GenericArray) object;
        return capacity == that.capacity && Objects.deepEquals(numberArray, that.numberArray);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(numberArray), capacity);
    }
}
