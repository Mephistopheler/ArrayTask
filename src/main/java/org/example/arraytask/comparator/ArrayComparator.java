package org.example.arraytask.comparator;

import java.math.BigInteger;
import java.util.Comparator;
import org.example.arraytask.entity.ArrayWrapper;

public enum ArrayComparator implements Comparator<ArrayWrapper> {
    BY_NAME(Comparator.comparing(ArrayWrapper::getName, Comparator.nullsFirst(String::compareTo))),
    BY_FIRST_ELEMENT(Comparator.comparing(
            array -> array.length() == 0 ? null : array.get(0),
            Comparator.nullsFirst(BigInteger::compareTo)
    )),
    BY_ELEMENT_COUNT(Comparator.comparingInt(ArrayWrapper::length));

    private final Comparator<ArrayWrapper> comparator;

    ArrayComparator(Comparator<ArrayWrapper> comparator) {
        this.comparator = comparator;
    }

    @Override
    public int compare(ArrayWrapper first, ArrayWrapper second) {
        return comparator.compare(first, second);
    }
}