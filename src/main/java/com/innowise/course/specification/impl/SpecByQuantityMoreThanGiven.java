package com.innowise.course.specification.impl;

import com.innowise.course.entity.AbstractArray;
import com.innowise.course.exception.ArrayException;
import com.innowise.course.specification.Specification;

public class SpecByQuantityMoreThanGiven implements Specification<AbstractArray<Number>> {

    private final int quantity;

    public SpecByQuantityMoreThanGiven(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean isSuitable(AbstractArray<Number> item) throws ArrayException {
        return item.getSize() > quantity;
    }
}
