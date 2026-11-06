package com.innowise.course.service.sortService.impl;

import com.innowise.course.entity.AbstractArray;
import com.innowise.course.exception.ArrayException;
import com.innowise.course.service.sortService.SortService;

public class QuickSortService implements SortService {

    @Override
    public void sortIntArray(AbstractArray<Number> arrayToSort) throws ArrayException {
        int n = arrayToSort.getSize();
        if (n < 2) return;
        quickSort(arrayToSort, 0, n - 1);
    }


    private void quickSort(AbstractArray<Number> a, int low, int high) throws ArrayException {
        if (low >= high) return;
        int pivotIndex = partition(a, low, high);
        quickSort(a, low, pivotIndex - 1);
        quickSort(a, pivotIndex + 1, high);
    }


    private int partition(AbstractArray<Number> a, int low, int high) throws ArrayException {
        int pivot = a.get(high).intValue();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (a.get(j).doubleValue() <= pivot) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, high);
        return i + 1;
    }

    private static void swap(AbstractArray<Number> a, int i, int j) throws ArrayException {
        Integer tmp = a.get(i).intValue();
        a.set(i, a.get(j));
        a.set(j, tmp);
    }
}
