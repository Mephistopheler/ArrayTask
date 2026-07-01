package org.example.arraytask.entity;


import org.example.arraytask.exception.ArrayTaskException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractArrayWrapper<T extends Number & Comparable<T>> {
    private static final Logger logger = LogManager.getLogger(AbstractArrayWrapper.class);

    protected T[] data;
    protected String name;

    protected AbstractArrayWrapper(T[] data, String name) {
        if (data == null) {
            logger.error("Data array is null");
            throw new IllegalArgumentException("Data array cannot be null");
        }
        this.data = data;
        this.name = name;
    }

    public T[] getData() {
        return data;
    }

    public void setData(T[] data) {
        if (data == null) {
            throw new IllegalArgumentException("Data array cannot be null");
        }
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return data.length;
    }

    public abstract double sum() throws ArrayTaskException;

    public abstract double average() throws ArrayTaskException;

    public abstract T findMax() throws ArrayTaskException;

    public abstract T findMin() throws ArrayTaskException;

    protected void ensureNonEmpty() throws ArrayTaskException {
        if (data.length == 0) {
            throw new ArrayTaskException("Array is empty");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(": [");
        for (int i = 0; i < data.length; i++) {
            builder.append(data[i]);
            if (i < data.length - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}