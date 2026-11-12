package com.innowise.course.repository.impl;

import com.innowise.course.entity.AbstractArray;
import com.innowise.course.repository.ArrayRepository;
import com.innowise.course.specification.Specification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayRepositoryImpl implements ArrayRepository {

    private final Map<Long,AbstractArray<Number>> storage = new HashMap<>();

    @Override
    public void add(AbstractArray<Number> abstractArray) {

    }

    @Override
    public void delete(AbstractArray<Number> abstractArray) {

    }

    @Override
    public List<AbstractArray<Number>> findGroupBySpec(Specification<Number> specification) {
        return List.of();
    }
}
