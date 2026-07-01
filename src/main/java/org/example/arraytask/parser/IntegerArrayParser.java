package org.example.arraytask.parser;

import org.example.arraytask.exception.ArrayTaskException;
import org.example.arraytask.validator.ArrayDataValidator;

public class IntegerArrayParser implements ArrayParser {
    private final ArrayDataValidator validator;

    public IntegerArrayParser(ArrayDataValidator validator) {
        this.validator = validator;
    }

    @Override
    public int[] parse(String line) throws ArrayTaskException {
        if (!validator.isValid(line)) {
            throw new ArrayTaskException("Invalid array data: " + line);
        }
        String trimmedLine = line.trim();
        if (trimmedLine.isEmpty()) {
            return new int[0];
        }
        String[] tokens = trimmedLine.split("\\s*[,;\\-\\s]\\s*");
        int[] values = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            values[i] = Integer.parseInt(tokens[i]);
        }
        return values;
    }
}