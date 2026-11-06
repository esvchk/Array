package com.innowise.course.service.minMaxService.impl;

import com.innowise.course.entity.AbstractArray;
import com.innowise.course.exception.ArrayException;
import com.innowise.course.service.minMaxService.MinMaxService;

import java.util.OptionalInt;

public class MinMaxServiceImpl implements MinMaxService {


    @Override
    public OptionalInt getMin(AbstractArray<Number> array) throws ArrayException {
        if (array == null || array.isEmpty()){
            return OptionalInt.empty();
        }

        int min = array.get(0).intValue();
        for (int i = 1; i < array.getSize(); i++) {
            if (array.get(i).intValue() < min) {
                min = array.get(i).intValue();
            }
        }
        return OptionalInt.of(min);
    }

    @Override
    public OptionalInt getMax(AbstractArray<Number> array) throws ArrayException {
        if (array == null || array.isEmpty()){
            return OptionalInt.empty();
        }
        int max = array.get(0).intValue();
        for (int i = 1; i < array.getSize(); i++) {
            if (array.get(i).intValue() > max) {
                max = array.get(i).intValue();
            }
        }
        return OptionalInt.of(max);
    }
}
