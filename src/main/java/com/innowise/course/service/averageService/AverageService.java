package com.innowise.course.service.averageService;

import com.innowise.course.entity.AbstractArray;
import com.innowise.course.exception.ArrayException;

import java.util.OptionalDouble;

public interface AverageService {
    OptionalDouble getAverage(AbstractArray<Number> array) throws ArrayException;
}
