package org.example.arraytask.validator;

public class IntegerArrayDataValidator implements ArrayDataValidator {
    private static final String INTEGER_ARRAY_PATTERN =
            "\\s*([+-]?\\d+\\s*([,;\\-\\s]\\s*[+-]?\\d+\\s*)*)?";

    @Override
    public boolean isValid(String line) {
        return line != null && line.matches(INTEGER_ARRAY_PATTERN);
    }
}