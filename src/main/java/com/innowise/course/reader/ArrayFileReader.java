package com.innowise.course.reader;

import com.innowise.course.exception.FileReadException;

import java.nio.file.Path;
import java.util.List;

public interface ArrayFileReader {
    List<String> read(Path path) throws FileReadException;
}
