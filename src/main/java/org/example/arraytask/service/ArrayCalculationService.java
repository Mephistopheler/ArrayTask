package org.example.arraytask.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;
import org.example.arraytask.entity.ArrayWrapper;

public interface ArrayCalculationService {
    Optional<BigInteger> findMinimum(ArrayWrapper arrayWrapper);

    Optional<BigInteger> findMaximum(ArrayWrapper arrayWrapper);

    Optional<BigInteger> calculateSum(ArrayWrapper arrayWrapper);

    Optional<BigDecimal> calculateAverage(ArrayWrapper arrayWrapper);
}