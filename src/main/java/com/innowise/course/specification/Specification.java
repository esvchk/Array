package com.innowise.course.specification;

import com.innowise.course.exception.ArrayException;

public interface Specification<T> {
    boolean isSuitable(T item) throws ArrayException;
}
