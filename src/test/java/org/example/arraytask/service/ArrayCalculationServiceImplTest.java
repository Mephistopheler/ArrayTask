package org.example.arraytask.service;

import org.example.arraytask.entity.ArrayWrapper;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class ArrayCalculationServiceImplTest {

    private final ArrayCalculationService service = new ArrayCalculationServiceImpl();

    @Test
    void shouldCalculateValuesForFilledArray() {

        ArrayWrapper arrayWrapper = new ArrayWrapper(
                new BigInteger[]{
                        BigInteger.valueOf(5),
                        BigInteger.valueOf(2),
                        BigInteger.valueOf(8),
                        BigInteger.valueOf(1)
                },
                "numbers"
        );

        assertEquals(
                BigInteger.valueOf(1),
                service.findMinimum(arrayWrapper).orElseThrow()
        );

        assertEquals(
                BigInteger.valueOf(8),
                service.findMaximum(arrayWrapper).orElseThrow()
        );

        assertEquals(
                BigInteger.valueOf(16),
                service.calculateSum(arrayWrapper).orElseThrow()
        );

        assertEquals(
                new BigDecimal("4"),
                service.calculateAverage(arrayWrapper).orElseThrow()
        );
    }

    @Test
    void shouldReturnEmptyOptionalForEmptyArray() {

        ArrayWrapper arrayWrapper = new ArrayWrapper(
                new BigInteger[0],
                "empty"
        );

        assertTrue(service.findMinimum(arrayWrapper).isEmpty());
        assertTrue(service.findMaximum(arrayWrapper).isEmpty());
        assertTrue(service.calculateSum(arrayWrapper).isEmpty());
        assertTrue(service.calculateAverage(arrayWrapper).isEmpty());
    }
}