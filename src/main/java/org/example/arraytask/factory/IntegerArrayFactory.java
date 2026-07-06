package org.example.arraytask.factory;

import org.example.arraytask.entity.ArrayWrapper;

import java.math.BigInteger;

public class IntegerArrayFactory implements ArrayFactory {
    @Override
    public ArrayWrapper create(BigInteger[] values, String name) {
        return new ArrayWrapper(values, name);
    }
}