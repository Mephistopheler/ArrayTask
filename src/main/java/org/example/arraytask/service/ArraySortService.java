package org.example.arraytask.service;

import org.example.arraytask.entity.ArrayWrapper;

public interface ArraySortService {
    ArrayWrapper sortByBubbleSort(ArrayWrapper arrayWrapper);

    ArrayWrapper sortByInsertionSort(ArrayWrapper arrayWrapper);
}