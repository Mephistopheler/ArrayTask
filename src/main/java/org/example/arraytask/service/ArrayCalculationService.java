package org.example.arraytask.service;

import java.util.Optional;
import org.example.arraytask.entity.ArrayWrapper;

public interface ArrayCalculationService {
    Optional<Integer> findMinimum(ArrayWrapper arrayWrapper);

    Optional<Integer> findMaximum(ArrayWrapper arrayWrapper);

    Optional<Integer> calculateSum(ArrayWrapper arrayWrapper);

    Optional<Double> calculateAverage(ArrayWrapper arrayWrapper);
}