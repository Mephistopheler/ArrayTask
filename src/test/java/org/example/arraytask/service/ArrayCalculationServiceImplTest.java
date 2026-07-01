package org.example.arraytask.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.example.arraytask.entity.ArrayWrapper;
import org.junit.jupiter.api.Test;

class ArrayCalculationServiceImplTest {
    private final ArrayCalculationService service = new ArrayCalculationServiceImpl();

    @Test
    void shouldCalculateValuesForFilledArray() {
        ArrayWrapper arrayWrapper = new ArrayWrapper(new int[] {5, 2, 8, 1}, "numbers");

        assertEquals(1, service.findMinimum(arrayWrapper).orElseThrow());
        assertEquals(8, service.findMaximum(arrayWrapper).orElseThrow());
        assertEquals(16, service.calculateSum(arrayWrapper).orElseThrow());
        assertEquals(4.0, service.calculateAverage(arrayWrapper).orElseThrow());
    }

    @Test
    void shouldReturnEmptyOptionalForEmptyArray() {
        ArrayWrapper arrayWrapper = new ArrayWrapper(new int[0], "empty");

        assertTrue(service.findMinimum(arrayWrapper).isEmpty());
        assertTrue(service.findMaximum(arrayWrapper).isEmpty());
        assertTrue(service.calculateSum(arrayWrapper).isEmpty());
        assertTrue(service.calculateAverage(arrayWrapper).isEmpty());
    }
}