package org.example.arraytask.entity;

import org.example.arraytask.observer.ArrayEvent;
import org.example.arraytask.observer.ArrayObserver;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ArrayWrapper {
    private final BigInteger[] values;
    private final String name;
    private final List<ArrayObserver> observers = new ArrayList<>();

    public ArrayWrapper(BigInteger[] values, String name) {
        if (values == null) {
            throw new IllegalArgumentException("Values cannot be null");
        }
        this.values = Arrays.copyOf(values, values.length);
        this.name = name;
    }



    public BigInteger[] getValues() {
        return Arrays.copyOf(values, values.length);
    }

    public BigInteger get(int index) {
        return values[index];
    }

    public void set(int index, BigInteger value) {
        values[index] = Objects.requireNonNull(value, "Value cannot be null");
        notifyObservers();
    }


    public String getName() {
        return name;
    }

    public int length() {
        return values.length;
    }


    public void attach(ArrayObserver observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void detach(ArrayObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        ArrayEvent event = new ArrayEvent(this);
        observers.forEach(observer -> observer.arrayChanged(event));
    }

    @Override
    public String toString() {
        return "ArrayWrapper{name='" + name + "', values=" + Arrays.toString(values) + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayWrapper that = (ArrayWrapper) o;
        return Arrays.equals(values, that.values) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(values);
        return result;
    }
}