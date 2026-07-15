package org.example.arraytask.specification;

import java.util.Objects;
import org.example.arraytask.entity.ArrayWrapper;

public class NameSpecification implements ArraySpecification {
    private final String name;

    public NameSpecification(String name) {
        this.name = name;
    }

    @Override
    public boolean specified(ArrayWrapper arrayWrapper) {
        String arrayName = arrayWrapper.getName();
        return arrayName == null ? name == null : arrayName.equals(name);
    }
}