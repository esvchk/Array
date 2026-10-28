package com.academy.course.service.minMaxService;

import com.academy.course.entity.AbstractArray;

import java.util.List;
import java.util.OptionalInt;

public interface MinMaxService {
    OptionalInt getMin(AbstractArray<Integer> array);
    OptionalInt getMax(AbstractArray<Integer> array);
}
