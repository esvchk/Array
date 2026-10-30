package com.academy.course.service.minMaxService;

import com.academy.course.entity.AbstractArray;
import com.academy.course.exception.ArrayException;

import java.util.List;
import java.util.OptionalInt;

public interface MinMaxService {
    OptionalInt getMin(AbstractArray<Integer> array) throws ArrayException;
    OptionalInt getMax(AbstractArray<Integer> array) throws ArrayException;
}
