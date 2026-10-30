package com.academy.course.service.sumService;

import com.academy.course.entity.AbstractArray;
import com.academy.course.exception.ArrayException;

import java.util.OptionalInt;

public interface SumService {
    OptionalInt getSum(AbstractArray<Integer> array) throws ArrayException;
}
