package com.innowise.course.repository;

import com.innowise.course.entity.AbstractArray;
import com.innowise.course.specification.Specification;

import java.util.List;

public interface ArrayRepository {
    void add(AbstractArray<Number> abstractArray);
    void delete(AbstractArray<Number> abstractArray);
    List<AbstractArray<Number>> findGroupBySpec(Specification<Number> specification);
}
