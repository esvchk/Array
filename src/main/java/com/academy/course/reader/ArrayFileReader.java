package com.academy.course.reader;

import com.academy.course.exception.FileReadException;

import java.nio.file.Path;
import java.util.List;

public interface ArrayFileReader {
    List<String> read(Path path) throws FileReadException;
}
