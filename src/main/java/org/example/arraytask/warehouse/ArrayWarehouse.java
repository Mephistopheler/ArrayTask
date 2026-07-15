package org.example.arraytask.warehouse;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.example.arraytask.entity.ArrayWrapper;
import org.example.arraytask.service.ArrayCalculationService;
import org.example.arraytask.service.ArrayCalculationServiceImpl;

public class ArrayWarehouse {
    private static final ArrayWarehouse INSTANCE = new ArrayWarehouse();

    private final Map<String, ArrayStatistics> statisticsByName = new HashMap<>();
    private final ArrayCalculationService calculationService = new ArrayCalculationServiceImpl();

    private ArrayWarehouse() {
    }

    public static ArrayWarehouse getInstance() {
        return INSTANCE;
    }

    public void put(ArrayWrapper arrayWrapper) {
        Optional<BigInteger> sum = calculationService.calculateSum(arrayWrapper);
        Optional<BigDecimal> average = calculationService.calculateAverage(arrayWrapper);
        Optional<BigInteger> maximum = calculationService.findMaximum(arrayWrapper);
        Optional<BigInteger> minimum = calculationService.findMinimum(arrayWrapper);
        statisticsByName.put(
                arrayWrapper.getName(),
                new ArrayStatistics(sum, average, maximum, minimum, arrayWrapper.length())
        );
    }

    public Optional<ArrayStatistics> get(String arrayName) {
        return Optional.ofNullable(statisticsByName.get(arrayName));
    }

    public void remove(String arrayName) {
        statisticsByName.remove(arrayName);
    }

    public void clear() {
        statisticsByName.clear();
    }
}