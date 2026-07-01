package org.example.arraytask.parser;

import org.example.arraytask.exception.ArrayTaskException;

public interface ArrayParser {
    int[] parse(String line) throws ArrayTaskException;
}