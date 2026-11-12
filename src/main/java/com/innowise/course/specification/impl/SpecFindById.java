package com.innowise.course.specification.impl;

import com.innowise.course.entity.AbstractArray;
import com.innowise.course.specification.Specification;

public class SpecFindById implements Specification<AbstractArray<Number>>{
    private final Long id;

    public SpecFindById(Long id) {
        this.id = id;
    }

    @Override
    public boolean isSuitable(AbstractArray<Number> item) {
        return item.getId().equals(id);
    }
}
