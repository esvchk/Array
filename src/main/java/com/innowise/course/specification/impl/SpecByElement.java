package com.innowise.course.specification.impl;

import com.innowise.course.entity.AbstractArray;
import com.innowise.course.exception.ArrayException;
import com.innowise.course.specification.Specification;

public class SpecByElement implements Specification<AbstractArray<Number>> {
    private final Number element;

    public SpecByElement(Number element) {
        this.element = element;
    }


    @Override
    public boolean isSuitable(AbstractArray<Number> item) throws ArrayException {
        for (int i = 0; i < item.getSize(); i++) {
            if (item.get(i).equals(element)) {
                return true;
            }
        }
        return false;
    }
}
