package com.innowise.course.service.sumService;

import com.innowise.course.entity.AbstractArray;
import com.innowise.course.entity.GenericArray;
import com.innowise.course.exception.ArrayException;

import java.util.OptionalInt;

public interface SumService {
    OptionalInt getSum(AbstractArray<Number> array) throws ArrayException;
}
