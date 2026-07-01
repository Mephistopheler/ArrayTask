package org.example.arraytask.entity;

import java.util.Arrays;

public class ArrayWrapper {
    private final int[] values;
    private final String name;

    public ArrayWrapper(int[] values, String name) {
        if (values == null) {
            throw new IllegalArgumentException("Values cannot be null");
        }
        this.values = Arrays.copyOf(values, values.length);
        this.name = name;
    }

    public int[] getValues() {
        return Arrays.copyOf(values, values.length);
    }

    public String getName() {
        return name;
    }

    public int length() {
        return values.length;
    }

    @Override
    public String toString() {
        return "ArrayWrapper{name='" + name + "', values=" + Arrays.toString(values) + "}";
    }
}