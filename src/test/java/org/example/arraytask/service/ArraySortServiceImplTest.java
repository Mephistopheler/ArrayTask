package org.example.arraytask.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.example.arraytask.entity.ArrayWrapper;
import org.junit.jupiter.api.Test;

class ArraySortServiceImplTest {
    private final ArraySortService service = new ArraySortServiceImpl();

    @Test
    void shouldSortUsingBubbleSort() {
        ArrayWrapper result = service.sortByBubbleSort(
                new ArrayWrapper(new int[] {3, 1, 2}, "numbers"));

        assertArrayEquals(new int[] {1, 2, 3}, result.getValues());
    }

    @Test
    void shouldSortUsingInsertionSort() {
        ArrayWrapper result = service.sortByInsertionSort(
                new ArrayWrapper(new int[] {9, 4, 7}, "numbers"));

        assertArrayEquals(new int[] {4, 7, 9}, result.getValues());
    }
}