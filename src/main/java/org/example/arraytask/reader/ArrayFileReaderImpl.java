package org.example.arraytask.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.arraytask.exception.ArrayTaskException;

public class ArrayFileReaderImpl implements ArrayFileReader {
    private static final Logger LOGGER = LogManager.getLogger(ArrayFileReaderImpl.class);

    @Override
    public List<String> readLines(Path path) throws ArrayTaskException {
        try {
            List<String> lines = Files.readAllLines(path);
            LOGGER.info("Read {} lines from {}", lines.size(), path);
            return lines;
        } catch (IOException e) {
            throw new ArrayTaskException("Cannot read file: " + path, e);
        }
    }
}