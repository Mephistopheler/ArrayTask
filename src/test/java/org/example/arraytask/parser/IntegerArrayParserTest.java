package org.example.arraytask.parser;

import org.example.arraytask.exception.ArrayTaskException;
import org.example.arraytask.validator.IntegerArrayDataValidator;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class IntegerArrayParserTest {

    private final ArrayParser parser =
            new IntegerArrayParser(new IntegerArrayDataValidator());

    @Test
    void shouldParseSupportedDelimiters() throws ArrayTaskException {

        assertArrayEquals(
                new BigInteger[]{
                        BigInteger.valueOf(1),
                        BigInteger.valueOf(2),
                        BigInteger.valueOf(3)
                },
                parser.parse("1; 2; 3")
        );



        assertArrayEquals(
                new BigInteger[]{
                        BigInteger.valueOf(3),
                        BigInteger.valueOf(4),
                        BigInteger.valueOf(7)
                },
                parser.parse("3 4 7")
        );

        assertArrayEquals(
                new BigInteger[0],
                parser.parse(" ")
        );
    }

    @Test
    void shouldRejectInvalidData() {
        assertThrows(
                ArrayTaskException.class,
                () -> parser.parse("1y1 21 32")
        );

        assertThrows(
                ArrayTaskException.class,
                () ->parser.parse("11- 2 - 42")
        );
    }
}