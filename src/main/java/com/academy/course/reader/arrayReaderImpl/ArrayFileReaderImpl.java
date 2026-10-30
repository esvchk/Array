package com.academy.course.reader.arrayReaderImpl;

import com.academy.course.exception.FileReadException;
import com.academy.course.reader.ArrayFileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayFileReaderImpl implements ArrayFileReader {


    public List<String> read(Path path) throws FileReadException {
        try {
            Charset charset = StandardCharsets.UTF_8;
            return Files.readAllLines(path,charset);
        } catch (IOException e) {
            throw new FileReadException("Cannot read file " + path, e);
        }
    }


}
