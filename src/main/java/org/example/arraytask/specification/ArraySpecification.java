package org.example.arraytask.specification;

import org.example.arraytask.entity.ArrayWrapper;

@FunctionalInterface
public interface ArraySpecification {
    boolean specified(ArrayWrapper arrayWrapper);
}