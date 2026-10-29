package com.academy.course.service.averageService.averageServiceImpl;

import com.academy.course.entity.AbstractArray;
import com.academy.course.service.averageService.AverageService;
import com.academy.course.service.sumService.SumService;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class AverageServiceImpl implements AverageService {

    private final SumService sumService;

    public AverageServiceImpl(SumService sumService) {
        this.sumService = sumService;
    }


    @Override
    public OptionalDouble getAverage(AbstractArray<Integer> array) {
        if (array == null || array.isEmpty()) return OptionalDouble.empty();
        int sum = sumService.getSum(array).getAsInt();
        double result = (double) sum / array.getSize();
        return OptionalDouble.of(result);
    }
}
