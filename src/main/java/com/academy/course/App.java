package com.academy.course;


import com.academy.course.entity.AbstractArray;
import com.academy.course.factory.AbstractArrayFactory;
import com.academy.course.factory.GenericArrayFactory;
import com.academy.course.parser.parserImpl.IntParser;
import com.academy.course.parser.Parser;
import com.academy.course.reader.ArrayFileReader;
import com.academy.course.reader.arrayReaderImpl.ArrayFileReaderImpl;
import com.academy.course.service.ArrayFillService;
import com.academy.course.service.fillServiceImpl.ArrayFillServiceImpl;
import com.academy.course.validator.charRefactor.refactorImpl.CharRefactor;
import com.academy.course.validator.validatorImpl.CommonValidator;

import java.io.IOException;
import java.util.List;


public class App {
    public static void main( String[] args ) {
        ArrayFileReader fileReader = new ArrayFileReaderImpl("D:\\courses\\project\\Array\\files\\data.txt");
        CharRefactor refactor = new CharRefactor();
        Parser parser = new IntParser();
        AbstractArrayFactory<Integer> factory = new GenericArrayFactory<>();
        AbstractArray<Integer> arr;
        CommonValidator validator = new CommonValidator();

        ArrayFillService fillService = new ArrayFillServiceImpl(fileReader,validator,refactor,parser,factory);
        List<AbstractArray> list = fillService.fillArray();
        list.forEach(System.out::println);

    }

}
