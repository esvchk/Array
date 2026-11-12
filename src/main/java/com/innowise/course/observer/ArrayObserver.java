package com.innowise.course.observer;


import com.innowise.course.entity.GenericArray;
import com.innowise.course.exception.ArrayException;

@FunctionalInterface
public interface ArrayObserver {
    void onArrayChanged(GenericArray array) throws ArrayException;
}
