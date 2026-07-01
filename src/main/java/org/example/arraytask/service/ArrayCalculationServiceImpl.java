package org.example.arraytask.service;

import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.arraytask.entity.ArrayWrapper;

public class ArrayCalculationServiceImpl implements ArrayCalculationService {
    private static final Logger LOGGER = LogManager.getLogger(ArrayCalculationServiceImpl.class);

    @Override
    public Optional<Integer> findMinimum(ArrayWrapper arrayWrapper) {
        int[] values = arrayWrapper.getValues();
        if (values.length == 0) {
            LOGGER.warn("Cannot find minimum for an empty array");
            return Optional.empty();
        }
        int minimum = values[0];
        for (int value : values) {
            if (value < minimum) {
                minimum = value;
            }
        }
        return Optional.of(minimum);
    }

    @Override
    public Optional<Integer> findMaximum(ArrayWrapper arrayWrapper) {
        int[] values = arrayWrapper.getValues();
        if (values.length == 0) {
            LOGGER.warn("Cannot find maximum for an empty array");
            return Optional.empty();
        }
        int maximum = values[0];
        for (int value : values) {
            if (value > maximum) {
                maximum = value;
            }
        }
        return Optional.of(maximum);
    }

    @Override
    public Optional<Integer> calculateSum(ArrayWrapper arrayWrapper) {
        int[] values = arrayWrapper.getValues();
        if (values.length == 0) {
            LOGGER.warn("Cannot calculate sum for an empty array");
            return Optional.empty();
        }
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return Optional.of(sum);
    }

    @Override
    public Optional<Double> calculateAverage(ArrayWrapper arrayWrapper) {
        Optional<Integer> sum = calculateSum(arrayWrapper);
        if (sum.isEmpty()) {
            LOGGER.warn("Cannot calculate average for an empty array");
            return Optional.empty();
        }
        return Optional.of((double) sum.get() / arrayWrapper.length());
    }
}