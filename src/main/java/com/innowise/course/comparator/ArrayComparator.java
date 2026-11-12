package com.innowise.course.comparator;

import com.innowise.course.entity.AbstractArray;
import com.innowise.course.warehouse.Warehouse;

import java.util.Comparator;

public class ArrayComparator {
    public static Comparator<AbstractArray<Number>> byId() {
        return Comparator.comparing(AbstractArray::getId);
    }


    public static Comparator<AbstractArray<Number>> bySize() {
        return Comparator.comparingInt(AbstractArray::getSize);
    }

    public static Comparator<AbstractArray<Number>> byTotal() {
        return Comparator.comparingInt(array ->
                Warehouse.getInstance().getInfo().get(array.getId()).total()
        );
    }


    public static Comparator<AbstractArray<Number>> byAverage() {
        return Comparator.comparingDouble(array ->
                Warehouse.getInstance().getInfo().get(array.getId()).average()
        );
    }


    public static Comparator<AbstractArray<Number>> byFirstElement() {
        return (a1, a2) -> {
            try {
                if (a1.getSize() == 0 && a2.getSize() == 0) return 0;
                if (a1.getSize() == 0) return -1;
                if (a2.getSize() == 0) return 1;
                return Double.compare(a1.get(0).doubleValue(), a2.get(0).doubleValue());
            } catch (Exception e) {
                return 0;
            }
        };
    }
}
