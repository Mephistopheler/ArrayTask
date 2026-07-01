package org.example.arrayTask.entity;


import org.example.arrayTask.exception.ArrayProcessingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumberArrayWrapper<T extends Number & Comparable<T>> extends AbstractArrayWrapper<T> {
    private static final Logger logger = LogManager.getLogger(NumberArrayWrapper.class);

    public NumberArrayWrapper(T[] data, String name) {
        super(data, name);
    }

    @Override
    public double sum() throws ArrayProcessingException {
        ensureNonEmpty();
        logger.debug("Calculating sum for array: {}", name);
        double total = 0.0;
        for (T value : data) {
            total += value.doubleValue();
        }
        return total;
    }

    @Override
    public double average() throws ArrayProcessingException {
        ensureNonEmpty();
        logger.debug("Calculating average for array: {}", name);
        return sum() / data.length;
    }

    @Override
    public T findMax() throws ArrayProcessingException {
        ensureNonEmpty();
        logger.debug("Finding max for array: {}", name);
        T max = data[0];
        for (T value : data) {
            if (value.compareTo(max) > 0) {
                max = value;
            }
        }
        return max;
    }

    @Override
    public T findMin() throws ArrayProcessingException {
        ensureNonEmpty();
        logger.debug("Finding min for array: {}", name);
        T min = data[0];
        for (T value : data) {
            if (value.compareTo(min) < 0) {
                min = value;
            }
        }
        return min;
    }
}