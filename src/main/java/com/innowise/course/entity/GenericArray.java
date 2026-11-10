package com.innowise.course.entity;

import com.innowise.course.exception.ArrayException;
import com.innowise.course.observer.ArrayObserver;
import com.innowise.course.observer.ArraySubject;
import com.innowise.course.utils.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Objects;

public class GenericArray extends AbstractArray<Number> {

    private final Logger logger = LogManager.getLogger(GenericArray.class);
    private final ArraySubject arraySubject = new ArraySubject();

    private Number[] numberArray;
    private int capacity;


    public GenericArray() {
        this(Constants.DEFAULT_ARRAY_CAPACITY);
    }

    public GenericArray(int capacity) {
        this.capacity = capacity;
        this.numberArray = new Number[capacity];
    }

    public void addObserver(ArrayObserver obs){
        arraySubject.register(obs);
    }

    public void removeObserver(ArrayObserver obs){
        arraySubject.delete(obs);
    }

    @Override
    public Number get(int index) throws ArrayException {
        checkIndex(index);
        return numberArray[index];
    }

    public Number[] getArray(){
        return Arrays.copyOf(numberArray,size);
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
        arraySubject.notifyOnChanged(this);
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
        arraySubject.notifyOnChanged(this);
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

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericArray that = (GenericArray) o;
        if (size != that.size) return false;
        for (int i = 0; i < size; i++) {
            if (!Objects.equals(numberArray[i], that.numberArray[i])) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(Arrays.copyOf(numberArray,size));
    }
}
