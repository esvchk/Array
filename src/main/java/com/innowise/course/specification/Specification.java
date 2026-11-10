package com.innowise.course.specification;

@FunctionalInterface
public interface Specification<T> {
    boolean isSuitable(T item);
}
