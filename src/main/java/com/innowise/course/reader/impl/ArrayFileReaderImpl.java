package com.innowise.course.reader.impl;

import com.innowise.course.exception.FileReadException;
import com.innowise.course.reader.ArrayFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ArrayFileReaderImpl implements ArrayFileReader {

    private final Logger logger = LogManager.getLogger(ArrayFileReaderImpl.class);

    public List<String> read(Path path) throws FileReadException {
        try {
            Charset charset = StandardCharsets.UTF_8;
            return Files.readAllLines(path,charset);
        } catch (IOException e) {
            logger.error("Cannot read a file with path{}",path);
            throw new FileReadException("Cannot read file " + path, e);
        }
    }


}
