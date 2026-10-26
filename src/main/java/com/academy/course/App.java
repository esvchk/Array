package com.academy.course;


import com.academy.course.entity.AbstractArray;
import com.academy.course.entity.GenericArray;
import com.academy.course.factory.ArrayFactory;
import com.academy.course.factory.GenericArrayFactory;

import java.util.Arrays;

public class App {
    public static void main( String[] args ) {
        ArrayFactory<Integer> factory = new GenericArrayFactory<>();
        AbstractArray<Integer> array = factory.create(10);
        AbstractArray<Integer> array1 = factory.fill(new Integer[]{1,2,3});
        System.out.println(array1);




    }
}
