package com.academy.course;


import com.academy.course.entity.AbstractArray;
import com.academy.course.factory.ArrayFactory;
import com.academy.course.factory.GenericArrayFactory;
import com.academy.course.reader.ArrayFileReader;
import com.academy.course.reader.ArrayFileReaderImpl;
import com.academy.course.validator.CommonValidator;
import com.academy.course.validator.ValidationResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class App {
    public static void main( String[] args ) {
        ArrayFactory<Integer> factory = new GenericArrayFactory<>();
        AbstractArray<Integer> array = factory.create(10);
        AbstractArray<Integer> array1 = factory.fill(new Integer[]{1,2,3});
        ArrayFileReader fileReader = new ArrayFileReaderImpl("D:\\courses\\project\\Array\\files\\data.txt");
        CommonValidator commonValidator = new CommonValidator();
        for (String s : fileReader.read()){
            System.out.println(commonValidator.validationResult(s));
        }
        }

}
