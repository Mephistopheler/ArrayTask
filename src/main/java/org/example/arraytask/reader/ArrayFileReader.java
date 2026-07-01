package org.example.arraytask.reader;

import java.nio.file.Path;
import java.util.List;
import org.example.arraytask.exception.ArrayTaskException;

public interface ArrayFileReader {
    List<String> readLines(Path path) throws ArrayTaskException;
}