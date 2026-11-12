package com.innowise.course;


import com.innowise.course.comparator.ArrayComparator;
import com.innowise.course.entity.AbstractArray;
import com.innowise.course.exception.ArrayException;
import com.innowise.course.exception.FileReadException;
import com.innowise.course.factory.AbstractArrayFactory;
import com.innowise.course.factory.GenericArrayFactory;
import com.innowise.course.parser.IntParser;
import com.innowise.course.parser.impl.IntParserImpl;
import com.innowise.course.reader.ArrayFileReader;
import com.innowise.course.reader.impl.ArrayFileReaderImpl;
import com.innowise.course.repository.ArrayRepository;
import com.innowise.course.repository.impl.ArrayRepositoryImpl;
import com.innowise.course.service.averageService.AverageService;
import com.innowise.course.service.averageService.impl.AverageServiceImpl;
import com.innowise.course.service.minMaxService.MinMaxService;
import com.innowise.course.service.minMaxService.impl.MinMaxServiceImpl;
import com.innowise.course.service.sortService.SortService;
import com.innowise.course.service.sortService.impl.BubbleSortService;
import com.innowise.course.service.sortService.impl.QuickSortService;
import com.innowise.course.service.sumService.SumService;
import com.innowise.course.service.sumService.impl.SumServiceImpl;
import com.innowise.course.specification.impl.SpecByElement;
import com.innowise.course.specification.impl.SpecByTotalMoreThanGiven;
import com.innowise.course.specification.impl.SpecFindById;
import com.innowise.course.validator.Validator;
import com.innowise.course.validator.charRefactor.Refactor;
import com.innowise.course.validator.charRefactor.impl.CharRefactor;
import com.innowise.course.validator.validatorImpl.*;
import com.innowise.course.warehouse.Warehouse;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class App {

    public static void main( String[] args ) throws ArrayException, FileReadException {
        ArrayFileReader fileReader = new ArrayFileReaderImpl();
        ArrayRepository repository = new ArrayRepositoryImpl();
        CharRefactor refactor = new CharRefactor();
        IntParser intParser = new IntParserImpl();
        List<Validator> sourceValidators = new ArrayList<>();
        List<Validator> newLineValidators = new ArrayList<>();
        AbstractArrayFactory<Number> factory = new GenericArrayFactory();
        CommonValidator validator = new CommonValidator(refactor,sourceValidators,newLineValidators);
        sourceValidators.add(new NotEmptyValidator());
        sourceValidators.add(new CharsValidator());
        newLineValidators.add(new DashValidator());
        newLineValidators.add(new NumberCharValidator());


        System.out.println("Read lines");
        List<AbstractArray<Number>> fromFile = fillArray(fileReader,validator,refactor,intParser,factory);
        for (AbstractArray<Number> array : fromFile){
            repository.add(array);
            System.out.println("Adding array with id " + array.getId());
        }

        System.out.println("WareHouse info");
        Warehouse.getInstance().getInfo().forEach((id,info) ->
                System.out.println()
        );

        System.out.println("Changing array element");
        AbstractArray<Number> array1 = fromFile.get(0);
        System.out.println("Values array before " + array1);
        System.out.println("Values WareHouse before " + Warehouse.getInstance().getInfo().get(array1.getId()));
        array1.set(0,100);
        System.out.println("Values array after " + array1);
        System.out.println("Values Warehouse after " + Warehouse.getInstance().getInfo().get(array1.getId()));


        System.out.println("Specification search");

        List<AbstractArray<Number>> byId = repository.findGroupBySpec(new SpecFindById(1L));
        System.out.println("Founded arrays with id 1" + byId);

        List<AbstractArray<Number>> byElement = repository.findGroupBySpec(new SpecByElement(1));
        System.out.println("Founded with element 1 " + byElement);

        List<AbstractArray<Number>> byTotal = repository.findGroupBySpec(new SpecByTotalMoreThanGiven(30));
        System.out.println("Founded with total more 30 " + byTotal);



        System.out.println("Repo sorting");

        List<AbstractArray<Number>> allArrays = repository.findGroupBySpec(item -> true);
        allArrays.sort(ArrayComparator.byId());
        System.out.println("Sort by Id");
        allArrays.forEach(a -> System.out.println("id " + a.getId()));
        allArrays.sort(ArrayComparator.byTotal());
        System.out.println("Sort by total");
        allArrays.forEach(a -> System.out.println("Total " + Warehouse.getInstance()
                .getInfo().get(a.getId()).total()));


        System.out.println("Repo removing");

        Long removalId = 1L;
        repository.delete(removalId);
        System.out.println("Removed with id " + removalId);
        System.out.println("Left in warehouse " + Warehouse.getInstance().getInfo().keySet());
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


}
