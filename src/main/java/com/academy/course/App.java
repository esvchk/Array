package com.academy.course;


import com.academy.course.entity.AbstractArray;
import com.academy.course.entity.GenericArray;
import com.academy.course.factory.ArrayFactory;
import com.academy.course.factory.GenericArrayFactory;
import com.academy.course.parser.IntParser;
import com.academy.course.parser.Parser;
import com.academy.course.reader.ArrayFileReader;
import com.academy.course.reader.ArrayFileReaderImpl;
import com.academy.course.validator.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class App {
    public static void main( String[] args ) {
        ArrayFileReader fileReader = new ArrayFileReaderImpl("D:\\courses\\project\\Array\\files\\data.txt");
        CharRefactor refactor = new CharRefactor();
        Parser parser = new IntParser();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayFactory<Integer> factory = new GenericArrayFactory<>();
        AbstractArray<Integer> arr = factory.create(10);



        for (String s: fileReader.read()){
            arr = factory.fill(parser.parseToInt(s,refactor));
            System.out.println(arr);
        }


    }

}
