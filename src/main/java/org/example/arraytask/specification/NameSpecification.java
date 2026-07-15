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
        return Objects.equals(arrayWrapper.getName(), name);
    }
}