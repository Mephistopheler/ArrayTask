package org.example.arraytask.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.arraytask.entity.ArrayWrapper;

public class ArraySortServiceImpl implements ArraySortService {
    private static final Logger LOGGER = LogManager.getLogger(ArraySortServiceImpl.class);

    @Override
    public ArrayWrapper sortByBubbleSort(ArrayWrapper arrayWrapper) {
        int[] values = arrayWrapper.getValues();
        for (int i = 0; i < values.length - 1; i++) {
            for (int j = 0; j < values.length - i - 1; j++) {
                if (values[j] > values[j + 1]) {
                    int temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                }
            }
        }
        LOGGER.info("Array was sorted with bubble sort: {}", arrayWrapper.getName());
        return new ArrayWrapper(values, arrayWrapper.getName());
    }

    @Override
    public ArrayWrapper sortByInsertionSort(ArrayWrapper arrayWrapper) {
        int[] values = arrayWrapper.getValues();
        for (int i = 1; i < values.length; i++) {
            int key = values[i];
            int j = i - 1;
            while (j >= 0 && values[j] > key) {
                values[j + 1] = values[j];
                j--;
            }
            values[j + 1] = key;
        }
        LOGGER.info("Array was sorted with insertion sort: {}", arrayWrapper.getName());
        return new ArrayWrapper(values, arrayWrapper.getName());
    }
}