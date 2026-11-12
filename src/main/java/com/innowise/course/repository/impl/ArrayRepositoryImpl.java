package com.innowise.course.repository.impl;

import com.innowise.course.entity.AbstractArray;
import com.innowise.course.entity.GenericArray;
import com.innowise.course.exception.ArrayException;
import com.innowise.course.observer.ArrayObserver;
import com.innowise.course.repository.ArrayRepository;
import com.innowise.course.specification.Specification;
import com.innowise.course.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ArrayRepositoryImpl implements ArrayRepository {


    private final Logger logger = LogManager.getLogger(ArrayRepositoryImpl.class);
    private final List<AbstractArray<Number>> storage = new ArrayList<>();
    private final ArrayObserver observer;
    private final AtomicLong idGenerator = new AtomicLong(1);


    public ArrayRepositoryImpl() {
        this.observer = array -> {
            Warehouse.getInstance().refreshData(array);
        };
    }

    @Override
    public void add(AbstractArray<Number> abstractArray) throws ArrayException {
        if (abstractArray.getId() == null) {
            abstractArray.setId(idGenerator.getAndIncrement());
        } else if (storage.stream()
                .anyMatch(abstractArray1 -> abstractArray1.getId().equals(abstractArray.getId()))) {
            logger.error("Duplicate Id {}", abstractArray.getId());
            throw new ArrayException("Element with the same id already exists");
        }
        ((GenericArray) abstractArray).addObserver(observer);
        storage.add(abstractArray);
        Warehouse.getInstance().refreshData(abstractArray);
    }

    @Override
    public void delete(Long id) throws ArrayException {
        if (id != null && storage.stream().anyMatch(abstractArray -> abstractArray.getId().equals(id))) {
            ((GenericArray) storage.get(id.intValue())).removeObserver(observer);
            Warehouse.getInstance().removeData(storage.get(id.intValue()));
            storage.remove(id.intValue());
        } else {
            logger.error("Id {} not found", id);
            throw new ArrayException("Object for removal not found");
        }
    }

    @Override
    public List<AbstractArray<Number>> findGroupBySpec(Specification<AbstractArray<Number>> specification) throws ArrayException {
        List<AbstractArray<Number>> arrays = new ArrayList<>();
        for (AbstractArray<Number> array : storage) {
            if (specification.isSuitable(array)) {
                arrays.add(array);
            }
        }
        return arrays;
    }
}
