package org.example.arraytask.parser;

import org.example.arraytask.exception.ArrayTaskException;
import org.example.arraytask.validator.ArrayDataValidator;

import java.math.BigInteger;

public class IntegerArrayParser implements ArrayParser {
    private final ArrayDataValidator validator;

    public IntegerArrayParser(ArrayDataValidator validator) {
        this.validator = validator;
    }

    @Override
    public BigInteger[] parse(String line) throws ArrayTaskException {
        if (!validator.isValid(line)) {
            throw new ArrayTaskException("Invalid array data: " + line);
        }

        String trimmedLine = line.trim();

        if (trimmedLine.isEmpty()) {
            return new BigInteger[0];
        }

        String[] tokens = trimmedLine.split("\\s*[;,\\s]\\s*");

        BigInteger[] values = new BigInteger[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            try {
                values[i] = new BigInteger(tokens[i]);
            } catch (NumberFormatException e) {
                throw new ArrayTaskException("Invalid number: " + tokens[i], e);
            }
        }

        return values;
    }
}