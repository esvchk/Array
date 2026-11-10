package com.innowise.course.service.minMaxService;

import com.innowise.course.entity.AbstractArray;
import com.innowise.course.exception.ArrayException;

import java.util.OptionalInt;

public interface MinMaxService {
    OptionalInt getMin(AbstractArray<Integer> array) throws ArrayException;
    OptionalInt getMax(AbstractArray<Integer> array) throws ArrayException;
}
