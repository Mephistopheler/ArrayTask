package org.example.arraytask.factory;

import org.example.arraytask.entity.ArrayWrapper;

public interface ArrayFactory {
    ArrayWrapper create(int[] values, String name);
}