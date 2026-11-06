package com.innowise.course.service.sortService;

import com.innowise.course.entity.AbstractArray;
import com.innowise.course.exception.ArrayException;

public interface SortService {
    void sortIntArray(AbstractArray<Number> arrayToSort) throws ArrayException;

}
