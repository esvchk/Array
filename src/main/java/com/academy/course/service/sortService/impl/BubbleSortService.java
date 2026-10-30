package com.academy.course.service.sortService.impl;

import com.academy.course.entity.AbstractArray;
import com.academy.course.exception.ArrayException;
import com.academy.course.service.minMaxService.impl.MinMaxServiceImpl;
import com.academy.course.service.sortService.SortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BubbleSortService implements SortService {

    private final Logger logger = LogManager.getLogger(BubbleSortService.class);

    @Override
    public void sortIntArray(AbstractArray<Integer> arrayToSort) throws ArrayException {
        for (int i = 0; i < arrayToSort.getSize() - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arrayToSort.getSize() - 1 - i; j++) {
                if (arrayToSort.get(j) > arrayToSort.get(j + 1)) {
                    swap(arrayToSort, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    private void swap(AbstractArray<Integer> a, int i, int j) throws ArrayException {
        Integer tmp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, tmp);
    }
}
