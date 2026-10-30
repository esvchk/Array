package com.academy.course.service.sumService.impl;

import com.academy.course.entity.AbstractArray;
import com.academy.course.service.sumService.SumService;

import java.util.OptionalInt;

public class SumServiceImpl implements SumService {
    @Override
    public OptionalInt getSum(AbstractArray<Integer> array) {
        int sum = 0;
        for (int i = 0; i < array.getSize(); i++) {
            sum += array.get(i);
        }
        return OptionalInt.of(sum);
    }
}
