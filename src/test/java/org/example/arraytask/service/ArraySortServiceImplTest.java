package org.example.arraytask.service;

import org.example.arraytask.entity.ArrayWrapper;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArraySortServiceImplTest {

    private final ArraySortService service = new ArraySortServiceImpl();

    @Test
    void shouldSortUsingBubbleSort() {

        ArrayWrapper result = service.sortByBubbleSort(
                new ArrayWrapper(
                        new BigInteger[]{
                                BigInteger.valueOf(3),
                                BigInteger.valueOf(1),
                                BigInteger.valueOf(2)
                        },
                        "numbers"
                )
        );

        assertArrayEquals(
                new BigInteger[]{
                        BigInteger.valueOf(1),
                        BigInteger.valueOf(2),
                        BigInteger.valueOf(3)
                },
                result.getValues()
        );
    }

    @Test
    void shouldSortUsingInsertionSort() {

        ArrayWrapper result = service.sortByInsertionSort(
                new ArrayWrapper(
                        new BigInteger[]{
                                BigInteger.valueOf(9),
                                BigInteger.valueOf(4),
                                BigInteger.valueOf(7)
                        },
                        "numbers"
                )
        );

        assertArrayEquals(
                new BigInteger[]{
                        BigInteger.valueOf(4),
                        BigInteger.valueOf(7),
                        BigInteger.valueOf(9)
                },
                result.getValues()
        );
    }
}