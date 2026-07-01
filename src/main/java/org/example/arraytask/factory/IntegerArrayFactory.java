package org.example.arraytask.factory;

import org.example.arraytask.entity.ArrayWrapper;

public class IntegerArrayFactory implements ArrayFactory {
    @Override
    public ArrayWrapper create(int[] values, String name) {
        return new ArrayWrapper(values, name);
    }
}