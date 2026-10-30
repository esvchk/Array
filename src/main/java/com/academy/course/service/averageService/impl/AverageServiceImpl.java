package com.academy.course.service.averageService.impl;

import com.academy.course.entity.AbstractArray;
import com.academy.course.exception.ArrayException;
import com.academy.course.parser.parserImpl.IntParserImpl;
import com.academy.course.service.averageService.AverageService;
import com.academy.course.service.sumService.SumService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalDouble;

public class AverageServiceImpl implements AverageService {

    private final SumService sumService;

    public AverageServiceImpl(SumService sumService) {
        this.sumService = sumService;
    }

    private final Logger logger = LogManager.getLogger(AverageServiceImpl.class);

    @Override
    public OptionalDouble getAverage(AbstractArray<Integer> array) throws ArrayException {
        if (array == null || array.isEmpty()) {
            return OptionalDouble.empty();
        }
        int sum = sumService.getSum(array).getAsInt();
        double result = (double) sum / array.getSize();
        return OptionalDouble.of(result);
    }
}
