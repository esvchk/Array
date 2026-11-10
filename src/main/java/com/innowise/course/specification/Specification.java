package com.innowise.course.specification;

public interface Specification<T> {
    boolean isSuitable(T item);
}
