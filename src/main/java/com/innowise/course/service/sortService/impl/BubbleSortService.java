package com.innowise.course.service.sortService.impl;

import com.innowise.course.entity.AbstractArray;
import com.innowise.course.exception.ArrayException;
import com.innowise.course.service.sortService.SortService;

public class BubbleSortService implements SortService {


    @Override
    public void sortIntArray(AbstractArray<Number> arrayToSort) throws ArrayException {
        for (int i = 0; i < arrayToSort.getSize() - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arrayToSort.getSize() - 1 - i; j++) {
                if (arrayToSort.get(j).intValue() > arrayToSort.get(j + 1).doubleValue()) {
                    swap(arrayToSort, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    private void swap(AbstractArray<Number> a, int i, int j) throws ArrayException {
        Integer tmp = a.get(i).intValue();
        a.set(i, a.get(j));
        a.set(j, tmp);
    }
}
