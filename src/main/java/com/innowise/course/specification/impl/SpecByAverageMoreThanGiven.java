package com.innowise.course.specification.impl;

import com.innowise.course.entity.AbstractArray;
import com.innowise.course.exception.ArrayException;
import com.innowise.course.specification.Specification;
import com.innowise.course.warehouse.ArrayInfo;
import com.innowise.course.warehouse.Warehouse;

public class SpecByAverageMoreThanGiven implements Specification<AbstractArray<Number>> {

    private final double average;

    public SpecByAverageMoreThanGiven(double average) {
        this.average = average;
    }


    @Override
    public boolean isSuitable(AbstractArray<Number> item)  {
        ArrayInfo arrayInfo = Warehouse.getInstance().getInfo().get(item.getId());
        return arrayInfo.average() > average;
    }
}
