package com.academy.course.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayFileReaderImpl implements ArrayFileReader{

    private final String path;

    public ArrayFileReaderImpl(String path) {
        this.path = path;
    }

    public List<String> read(){
        List<String> stringList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(path))){
            while (scanner.hasNextLine()){
                String part = scanner.next();
                stringList.add(part);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
            //custom exception
        }
        return stringList;
    }


}
