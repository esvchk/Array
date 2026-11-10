package com.innowise.course.observer;

import com.innowise.course.entity.AbstractArray;

public interface ArrayObserver {
    void onArrayChanged(AbstractArray<Number> abstractArray);
}
