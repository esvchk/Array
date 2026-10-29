package com.academy.course.service.minMaxService.minMaxServiceImpl;

import com.academy.course.entity.AbstractArray;
import com.academy.course.service.minMaxService.MinMaxService;

import java.util.OptionalInt;

public class MinMaxServiceImpl implements MinMaxService {
    @Override
    public OptionalInt getMin(AbstractArray<Integer> array) {
        if (array == null || array.isEmpty()) return OptionalInt.empty();
        int min = array.get(0);
        for (int i = 1; i < array.getSize(); i++) {
            if (array.get(i) < min) {
                min = array.get(i);
            }
        }
        return OptionalInt.of(min);
    }

    @Override
    public OptionalInt getMax(AbstractArray<Integer> array) {
        if (array == null || array.isEmpty()) return OptionalInt.empty();
        int max = array.get(0);
        for (int i = 1; i < array.getSize(); i++) {
            if (array.get(i) > max) {
                max = array.get(i);
            }
        }
        return OptionalInt.of(max);
    }
}
