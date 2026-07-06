package org.example.arraytask.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.arraytask.entity.ArrayWrapper;

public class ArrayCalculationServiceImpl implements ArrayCalculationService {
    private static final Logger LOGGER = LogManager.getLogger(ArrayCalculationServiceImpl.class);

    @Override
    public Optional<BigInteger> findMinimum(ArrayWrapper arrayWrapper) {
        BigInteger[] values = arrayWrapper.getValues();
        if (values.length == 0) {
            LOGGER.warn("Cannot find minimum for an empty array");
            return Optional.empty();
        }
        BigInteger minimum = values[0];

        for (BigInteger value : values) {
            if (value.compareTo(minimum) < 0) {
                minimum = value;
            }
        }
        return Optional.of(minimum);
    }

    @Override
    public Optional<BigInteger> findMaximum(ArrayWrapper arrayWrapper) {
        BigInteger[] values = arrayWrapper.getValues();
        if (values.length == 0) {
            LOGGER.warn("Cannot find maximum for an empty array");
            return Optional.empty();
        }
        BigInteger maximum = values[0];

        for (BigInteger value : values) {
            if (value.compareTo(maximum) > 0) {
                maximum = value;
            }
        }
        return Optional.of(maximum);
    }

    @Override
    public Optional<BigInteger> calculateSum(ArrayWrapper arrayWrapper) {
        BigInteger[] values = arrayWrapper.getValues();
        if (values.length == 0) {
            LOGGER.warn("Cannot calculate sum for an empty array");
            return Optional.empty();
        }
        BigInteger sum = BigInteger.ZERO;

        for (BigInteger value : values) {
            sum = sum.add(value);
        }
        return Optional.of(sum);
    }

    @Override
    public Optional<BigDecimal> calculateAverage(ArrayWrapper arrayWrapper) {

        Optional<BigInteger> sum = calculateSum(arrayWrapper);

        if (sum.isEmpty() || arrayWrapper.length() == 0) {
            LOGGER.warn("Cannot calculate average for an empty array");
            return Optional.empty();
        }

        BigDecimal result = new BigDecimal(sum.get())
                .divide(
                        new BigDecimal(arrayWrapper.length()),
                        RoundingMode.HALF_UP
                );

        return Optional.of(result);
    }
}