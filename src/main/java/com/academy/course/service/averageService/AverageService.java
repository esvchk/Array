package com.academy.course.service.averageService;

import com.academy.course.entity.AbstractArray;
import com.academy.course.exception.ArrayException;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface AverageService {
    OptionalDouble getAverage(AbstractArray<Integer> array) throws ArrayException;
}
