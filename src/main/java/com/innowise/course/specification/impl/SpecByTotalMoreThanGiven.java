package com.innowise.course.specification.impl;

import com.innowise.course.entity.AbstractArray;
import com.innowise.course.specification.Specification;
import com.innowise.course.warehouse.ArrayInfo;
import com.innowise.course.warehouse.Warehouse;

public class SpecByTotalMoreThanGiven implements Specification<AbstractArray<Number>> {

    private final int total;


    public SpecByTotalMoreThanGiven(Integer total) {
        this.total = total;
    }


    @Override
    public boolean isSuitable(AbstractArray<Number> item) {
        ArrayInfo arrayInfo = Warehouse.getInstance().getInfo().get(item.getId());
        return arrayInfo.total() > total;
    }
}
