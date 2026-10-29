package com.academy.course.service.sortService.sortServiceImpl;

import com.academy.course.entity.AbstractArray;
import com.academy.course.service.sortService.SortService;

public class QuickSortService implements SortService {

    @Override
    public void sortIntArray(AbstractArray<Integer> arrayToSort) {
        int n = arrayToSort.getSize();
        if (n < 2) return;
        quickSort(arrayToSort, 0, n - 1);
    }


    private void quickSort(AbstractArray<Integer> a, int low, int high) {
        if (low >= high) return;
        int pivotIndex = partition(a, low, high);
        quickSort(a, low, pivotIndex - 1);
        quickSort(a, pivotIndex + 1, high);
    }


    private int partition(AbstractArray<Integer> a, int low, int high) {
        Integer pivot = a.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (a.get(j) <= pivot) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, high);
        return i + 1;
    }

    private static void swap(AbstractArray<Integer> a, int i, int j) {
        Integer tmp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, tmp);
    }
}
