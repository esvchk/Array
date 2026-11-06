package com.innowise.course.service.sumService.impl;

import com.innowise.course.entity.AbstractArray;
import com.innowise.course.entity.GenericArray;
import com.innowise.course.exception.ArrayException;
import com.innowise.course.service.sumService.SumService;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class SumServiceImpl implements SumService {
    @Override
    public OptionalInt getSum(AbstractArray<Number> array) throws ArrayException {
        int sum = 0;
        for (int i = 0; i < array.getSize(); i++) {
            sum += array.get(i).intValue();
        }
        return OptionalInt.of(sum);
    }
}
