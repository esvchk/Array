package com.innowise.course.service.averageService.impl;

import com.innowise.course.entity.AbstractArray;
import com.innowise.course.exception.ArrayException;
import com.innowise.course.service.averageService.AverageService;
import com.innowise.course.service.sumService.SumService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalDouble;

public class AverageServiceImpl implements AverageService {

    private final SumService sumService;

    public AverageServiceImpl(SumService sumService) {
        this.sumService = sumService;
    }


    @Override
    public OptionalDouble getAverage(AbstractArray<Number> array) throws ArrayException {
        if (array == null || array.isEmpty()) {
            return OptionalDouble.empty();
        }
        int sum = sumService.getSum(array).getAsInt();
        double result = (double) sum / array.getSize();
        return OptionalDouble.of(result);
    }
}
