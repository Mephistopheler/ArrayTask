package org.example.arraytask.builder;

import java.util.ArrayList;
import java.util.List;
import org.example.arraytask.entity.ArrayWrapper;

public class IntegerArrayBuilder implements ArrayBuilder {
    private final List<Integer> values = new ArrayList<>();
    private String name = "array";

    @Override
    public ArrayBuilder name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public ArrayBuilder addValue(int value) {
        values.add(value);
        return this;
    }

    @Override
    public ArrayWrapper build() {
        int[] result = new int[values.size()];
        for (int i = 0; i < values.size(); i++) {
            result[i] = values.get(i);
        }
        return new ArrayWrapper(result, name);
    }
}