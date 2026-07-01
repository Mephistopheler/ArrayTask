package org.example.arraytask.parser;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.example.arraytask.exception.ArrayTaskException;
import org.example.arraytask.validator.IntegerArrayDataValidator;
import org.junit.jupiter.api.Test;

class IntegerArrayParserTest {
    private final ArrayParser parser = new IntegerArrayParser(new IntegerArrayDataValidator());

    @Test
    void shouldParseSupportedDelimiters() throws ArrayTaskException {
        assertArrayEquals(new int[] {1, 2, 3}, parser.parse("1; 2; 3"));
        assertArrayEquals(new int[] {11, 2, 42}, parser.parse("11- 2 - 42"));
        assertArrayEquals(new int[] {3, 4, 7}, parser.parse("3 4 7"));
        assertArrayEquals(new int[0], parser.parse(" "));
    }

    @Test
    void shouldRejectInvalidData() {
        assertThrows(ArrayTaskException.class, () -> parser.parse("1y1 21 32"));
    }
}