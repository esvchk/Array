package com.academy.course;


import com.academy.course.entity.AbstractArray;
import com.academy.course.exception.ArrayException;
import com.academy.course.exception.FileReadException;
import com.academy.course.factory.AbstractArrayFactory;
import com.academy.course.factory.GenericArrayFactory;
import com.academy.course.parser.IntParser;
import com.academy.course.parser.parserImpl.IntParserImpl;
import com.academy.course.reader.ArrayFileReader;
import com.academy.course.reader.arrayReaderImpl.ArrayFileReaderImpl;
import com.academy.course.service.averageService.AverageService;
import com.academy.course.service.averageService.impl.AverageServiceImpl;
import com.academy.course.service.minMaxService.MinMaxService;
import com.academy.course.service.minMaxService.impl.MinMaxServiceImpl;
import com.academy.course.service.sortService.SortService;
import com.academy.course.service.sortService.impl.BubbleSortService;
import com.academy.course.service.sortService.impl.QuickSortService;
import com.academy.course.service.sumService.SumService;
import com.academy.course.service.sumService.impl.SumServiceImpl;
import com.academy.course.validator.Validator;
import com.academy.course.validator.charRefactor.Refactor;
import com.academy.course.validator.charRefactor.impl.CharRefactor;
import com.academy.course.validator.validatorImpl.*;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class App {
    public static void main( String[] args ) throws ArrayException, FileReadException {

        ArrayFileReader fileReader = new ArrayFileReaderImpl();
        CharRefactor refactor = new CharRefactor();
        IntParser intParser = new IntParserImpl();
        List<Validator> sourceValidators = new ArrayList<>();
        List<Validator> newLineValidators = new ArrayList<>();
        AbstractArrayFactory<Integer> factory = new GenericArrayFactory<>();
        CommonValidator validator = new CommonValidator(refactor,sourceValidators,newLineValidators);
        sourceValidators.add(new NotEmptyValidator());
        sourceValidators.add(new CharsValidator());
        newLineValidators.add(new DashValidator());
        newLineValidators.add(new NumberCharValidator());
        MinMaxService minMaxService = new MinMaxServiceImpl();
        SumService sumService = new SumServiceImpl();
        AverageService averageService = new AverageServiceImpl(sumService);
        SortService bubbleSortService = new BubbleSortService();
        SortService quickSortService = new QuickSortService();

        for (AbstractArray<Integer> array : fillArray(fileReader,validator,refactor,intParser,factory)){
            System.out.println("Bubble sort");
            bubbleSortService.sortIntArray(array);
            System.out.println(array);
            System.out.println("quick sort");
            quickSortService.sortIntArray(array);
            System.out.println(array);
        }


    }

    public static List<AbstractArray<Integer>> fillArray(ArrayFileReader reader,
                                                         CommonValidator validator,
                                                         Refactor refactor,
                                                         IntParser parser,
                                                         AbstractArrayFactory<Integer> factory) throws ArrayException, FileReadException {
        String path = "files/data.txt";
        List<AbstractArray<Integer>> list = new ArrayList<>();
        for (String fileLine : reader.read(Path.of(path))){
            if (validator.validationResult(fileLine).isValid()) {
                AbstractArray<Integer> array = factory.fill(parser.parseToInt(fileLine,refactor));
                list.add(array);
            } else {
                System.out.println(validator.validationResult(fileLine).getErrors());
            }
        }
        return list;
    }

    public static void printArrays(List<AbstractArray<Integer>> arrays){
        for (AbstractArray<Integer> array : arrays){
            System.out.println(array);
        }
    }

}
