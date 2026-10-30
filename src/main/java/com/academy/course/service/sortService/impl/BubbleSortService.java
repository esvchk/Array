package com.academy.course.service.sortService.impl;

import com.academy.course.entity.AbstractArray;
import com.academy.course.service.sortService.SortService;

public class BubbleSortService implements SortService {

    @Override
    public void sortIntArray(AbstractArray<Integer> arrayToSort) {
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

    private void swap(AbstractArray<Integer> a, int i, int j) {
        Integer tmp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, tmp);
    }
}
