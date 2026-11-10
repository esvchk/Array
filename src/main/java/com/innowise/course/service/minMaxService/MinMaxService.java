package com.innowise.course.service.minMaxService;

import com.innowise.course.entity.AbstractArray;
import com.innowise.course.exception.ArrayException;

import java.util.OptionalInt;

public interface MinMaxService {
    OptionalInt getMin(AbstractArray<Number> array) throws ArrayException;
    OptionalInt getMax(AbstractArray<Number> array) throws ArrayException;
}
