package com.innowise.course.observer;


import com.innowise.course.entity.GenericArray;

@FunctionalInterface
public interface ArrayObserver {
    void onArrayChanged(GenericArray array);
}
