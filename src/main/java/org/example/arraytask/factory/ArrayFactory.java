package org.example.arraytask.factory;

import org.example.arraytask.entity.ArrayWrapper;

import java.math.BigInteger;

public interface ArrayFactory {
    ArrayWrapper create(BigInteger[] values, String name);
}