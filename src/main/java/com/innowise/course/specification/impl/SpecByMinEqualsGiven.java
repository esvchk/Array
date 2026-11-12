package com.innowise.course.specification.impl;

import com.innowise.course.entity.AbstractArray;
import com.innowise.course.exception.ArrayException;
import com.innowise.course.specification.Specification;
import com.innowise.course.warehouse.ArrayInfo;
import com.innowise.course.warehouse.Warehouse;

public class SpecByMinEqualsGiven implements Specification<AbstractArray<Number>> {

    private final int min;

    public SpecByMinEqualsGiven(int min) {
        this.min = min;
    }

    @Override
    public boolean isSuitable(AbstractArray<Number> item) throws ArrayException {
        ArrayInfo arrayInfo = Warehouse.getInstance().getInfo().get(item.getId());
        return arrayInfo.min() == min;
    }
}
