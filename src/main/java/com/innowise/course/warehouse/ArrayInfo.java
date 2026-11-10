package com.innowise.course.warehouse;

public class ArrayInfo {
    private final double average;
    private final double total;
    private final double max;
    private final double min;

    public ArrayInfo(double average, double total, double max, double min) {
        this.average = average;
        this.total = total;
        this.max = max;
        this.min = min;

    }

    public double getAverage() {
        return average;
    }

    public double getTotal() {
        return total;
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }


    @Override
    public String toString() {
        return String.format("sum=%.2f, avg=%.2f, max=%.2f, min=%.2f",total,average,max,min);
    }

}
