package com.innowise.course.warehouse;

import com.innowise.course.entity.AbstractArray;
import com.innowise.course.exception.ArrayException;
import com.innowise.course.service.averageService.AverageService;
import com.innowise.course.service.averageService.impl.AverageServiceImpl;
import com.innowise.course.service.minMaxService.MinMaxService;
import com.innowise.course.service.minMaxService.impl.MinMaxServiceImpl;
import com.innowise.course.service.sumService.SumService;
import com.innowise.course.service.sumService.impl.SumServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class Warehouse {
    private static Warehouse instance;
    private final SumService sumService = new SumServiceImpl();
    private final AverageService averageService = new AverageServiceImpl(sumService);
    private final MinMaxService minMaxService = new MinMaxServiceImpl();
    private final Map<Long,ArrayInfo> info = new HashMap<>();


    private Warehouse(){}


    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }


    public void refreshData(AbstractArray<Number> abstractArray) throws ArrayException {
        OptionalInt total = sumService.getSum(abstractArray);
        OptionalDouble average = averageService.getAverage(abstractArray);
        OptionalInt max = minMaxService.getMax(abstractArray);
        OptionalInt min = minMaxService.getMin(abstractArray);
        info.put(abstractArray.getId(),
                new ArrayInfo(min.getAsInt(), max.getAsInt(), average.getAsDouble(), total.getAsInt()));
    }

    public void removeData(AbstractArray<Number> abstractArray){
        info.remove(abstractArray.getId());
    }


    public Map<Long, ArrayInfo> getInfo() {
        return info;
    }
}
