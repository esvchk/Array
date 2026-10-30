package com.academy.course.service.sortService;

import com.academy.course.entity.AbstractArray;
import com.academy.course.exception.ArrayException;

public interface SortService {
    void sortIntArray(AbstractArray<Integer> arrayToSort) throws ArrayException;

}
