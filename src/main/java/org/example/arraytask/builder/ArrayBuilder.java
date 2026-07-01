package org.example.arraytask.builder;

import org.example.arraytask.entity.ArrayWrapper;

public interface ArrayBuilder {
    ArrayBuilder name(String name);

    ArrayBuilder addValue(int value);

    ArrayWrapper build();
}