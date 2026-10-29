package com.academy.course.service.fillServiceImpl;

import com.academy.course.entity.AbstractArray;
import com.academy.course.exception.InvalidInputException;
import com.academy.course.factory.AbstractArrayFactory;
import com.academy.course.parser.IntParser;
import com.academy.course.reader.ArrayFileReader;
import com.academy.course.service.ArrayFillService;
import com.academy.course.validator.charRefactor.Refactor;
import com.academy.course.validator.validatorImpl.CommonValidator;

import java.util.ArrayList;
import java.util.List;


public class ArrayFillServiceImpl implements ArrayFillService {

    private final ArrayFileReader reader;
    private final CommonValidator validator;
    private final Refactor refactor;
    private final IntParser intParser;
    private final AbstractArrayFactory factory;

    public ArrayFillServiceImpl(ArrayFileReader reader,
                                CommonValidator validator,
                                Refactor refactor,
                                IntParser intParser,
                                AbstractArrayFactory factory) {
        this.reader = reader;
        this.validator = validator;
        this.refactor = refactor;
        this.intParser = intParser;
        this.factory = factory;
    }


    @Override
    public List<AbstractArray<Integer>> fillIntArray() {
        List<AbstractArray<Integer>> arraysList = new ArrayList<>();
        for (String fileLine : reader.read()){
            if (validator.validationResult(fileLine).isValid()) {
                AbstractArray<Integer> array = factory.fill(intParser.parseToInt(fileLine,refactor));
                arraysList.add(array);
            } else {
                throw new InvalidInputException("Invalid data from " + fileLine);
            }
        }
        return arraysList;
    }
}
