package com.innowise.course;


import com.innowise.course.entity.AbstractArray;
import com.innowise.course.exception.ArrayException;
import com.innowise.course.exception.FileReadException;
import com.innowise.course.factory.AbstractArrayFactory;
import com.innowise.course.factory.GenericArrayFactory;
import com.innowise.course.parser.IntParser;
import com.innowise.course.parser.impl.IntParserImpl;
import com.innowise.course.reader.ArrayFileReader;
import com.innowise.course.reader.impl.ArrayFileReaderImpl;
import com.innowise.course.service.averageService.AverageService;
import com.innowise.course.service.averageService.impl.AverageServiceImpl;
import com.innowise.course.service.minMaxService.MinMaxService;
import com.innowise.course.service.minMaxService.impl.MinMaxServiceImpl;
import com.innowise.course.service.sortService.SortService;
import com.innowise.course.service.sortService.impl.BubbleSortService;
import com.innowise.course.service.sortService.impl.QuickSortService;
import com.innowise.course.service.sumService.SumService;
import com.innowise.course.service.sumService.impl.SumServiceImpl;
import com.innowise.course.validator.Validator;
import com.innowise.course.validator.charRefactor.Refactor;
import com.innowise.course.validator.charRefactor.impl.CharRefactor;
import com.innowise.course.validator.validatorImpl.*;

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
        AbstractArrayFactory<Number> factory = new GenericArrayFactory<>();
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

        for (AbstractArray<Number> array : fillArray(fileReader,validator,refactor,intParser,factory)){
            System.out.println("Bubble sort");
            bubbleSortService.sortIntArray(array);
            System.out.println(array);
            System.out.println("quick sort");
            quickSortService.sortIntArray(array);
            System.out.println(array);
        }

    }


    public static List<AbstractArray<Number>> fillArray(ArrayFileReader reader,
                                                         CommonValidator validator,
                                                         Refactor refactor,
                                                         IntParser parser,
                                                         AbstractArrayFactory<Number> factory) throws ArrayException, FileReadException {
        String path = "files/data.txt";
        List<AbstractArray<Number>> list = new ArrayList<>();
        for (String fileLine : reader.read(Path.of(path))){
            if (validator.validationResult(fileLine).isValid()) {
                AbstractArray<Number> array = factory.fill(parser.parseToInt(fileLine,refactor));
                list.add(array);
            } else {
                System.out.println(validator.validationResult(fileLine).getErrors());
            }
        }
        return list;
    }

    public static void printArrays(List<AbstractArray<Number>> arrays){
        for (AbstractArray<Number> array : arrays){
            System.out.println(array);
        }
    }

}
