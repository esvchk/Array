package com.academy.course;


import com.academy.course.entity.AbstractArray;
import com.academy.course.factory.AbstractArrayFactory;
import com.academy.course.factory.GenericArrayFactory;
import com.academy.course.parser.IntParser;
import com.academy.course.parser.parserImpl.IntParserImpl;
import com.academy.course.reader.ArrayFileReader;
import com.academy.course.reader.arrayReaderImpl.ArrayFileReaderImpl;
import com.academy.course.service.ArrayFillService;
import com.academy.course.service.averageService.AverageService;
import com.academy.course.service.averageService.averageServiceImpl.AverageServiceImpl;
import com.academy.course.service.fillServiceImpl.ArrayFillServiceImpl;
import com.academy.course.service.minMaxService.MinMaxService;
import com.academy.course.service.minMaxService.minMaxServiceImpl.MinMaxServiceImpl;
import com.academy.course.service.sortService.SortService;
import com.academy.course.service.sortService.sortServiceImpl.BubbleSortService;
import com.academy.course.service.sortService.sortServiceImpl.QuickSortService;
import com.academy.course.service.sumService.SumService;
import com.academy.course.service.sumService.sumServiceImpl.SumServiceImpl;
import com.academy.course.validator.Validator;
import com.academy.course.validator.charRefactor.refactorImpl.CharRefactor;
import com.academy.course.validator.validatorImpl.*;

import java.util.ArrayList;
import java.util.List;


public class App {
    public static void main( String[] args ) {
        ArrayFileReader fileReader = new ArrayFileReaderImpl("D:\\courses\\project\\Array\\files\\data.txt");
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
        SortService service = new BubbleSortService();
        SortService service1 = new QuickSortService();

        ArrayFillService fillService = new ArrayFillServiceImpl(fileReader,validator,refactor, intParser,factory);
        List<AbstractArray<Integer>> list = fillService.fillIntArray();
        for (AbstractArray<Integer> array : list){
            service1.sortIntArray(array);
            System.out.println(array);
        }
//        list.forEach(System.out::println);


    }

}
