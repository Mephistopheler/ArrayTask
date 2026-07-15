package org.example.arraytask.specification;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.Function;
import org.example.arraytask.entity.ArrayWrapper;
import org.example.arraytask.warehouse.ArrayStatistics;
import org.example.arraytask.warehouse.ArrayWarehouse;

public class StatisticSpecification implements ArraySpecification {
    private final Function<ArrayStatistics, Optional<? extends Comparable>> extractor;
    private final Comparable expected;
    private final ComparisonType comparisonType;

    public StatisticSpecification(
            Function<ArrayStatistics, Optional<? extends Comparable>> extractor,
            Comparable expected,
            ComparisonType comparisonType
    ) {
        this.extractor = extractor;
        this.expected = expected;
        this.comparisonType = comparisonType;
    }

    public static StatisticSpecification sum(Comparable expected, ComparisonType comparisonType) {
        return new StatisticSpecification(ArrayStatistics::sum, expected, comparisonType);
    }

    public static StatisticSpecification average(BigDecimal expected, ComparisonType comparisonType) {
        return new StatisticSpecification(ArrayStatistics::average, expected, comparisonType);
    }

    public static StatisticSpecification maximum(Comparable expected, ComparisonType comparisonType) {
        return new StatisticSpecification(ArrayStatistics::maximum, expected, comparisonType);
    }

    public static StatisticSpecification minimum(Comparable expected, ComparisonType comparisonType) {
        return new StatisticSpecification(ArrayStatistics::minimum, expected, comparisonType);
    }

    public static StatisticSpecification count(int expected, ComparisonType comparisonType) {
        return new StatisticSpecification(statistics -> Optional.of(statistics.count()), expected, comparisonType);
    }

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public boolean specified(ArrayWrapper arrayWrapper) {
        Optional<ArrayStatistics> statistics = ArrayWarehouse.getInstance().get(arrayWrapper.getName());
        if (statistics.isEmpty()) {
            return false;
        }
        Optional actual = extractor.apply(statistics.get());
        return actual.isPresent()
                && comparisonType.matches(((Comparable) actual.get()).compareTo(expected));
    }
}