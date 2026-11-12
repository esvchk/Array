package com.innowise.course.repository;

import com.innowise.course.entity.AbstractArray;
import com.innowise.course.exception.ArrayException;
import com.innowise.course.specification.Specification;

import java.util.List;

public interface ArrayRepository {
    void add(AbstractArray<Number> abstractArray) throws ArrayException;
    void delete(Long id) throws ArrayException;
    List<AbstractArray<Number>> findGroupBySpec(Specification<AbstractArray<Number>> specification) throws ArrayException;
}
