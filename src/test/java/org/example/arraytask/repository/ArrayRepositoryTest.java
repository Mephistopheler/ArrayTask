package org.example.arraytask.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigInteger;
import org.example.arraytask.comparator.ArrayComparator;
import org.example.arraytask.entity.ArrayWrapper;
import org.example.arraytask.specification.ComparisonType;
import org.example.arraytask.specification.NameSpecification;
import org.example.arraytask.specification.StatisticSpecification;
import org.example.arraytask.warehouse.ArrayWarehouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayRepositoryTest {
    private final ArrayRepository repository = ArrayRepository.getInstance();
    private final ArrayWarehouse warehouse = ArrayWarehouse.getInstance();

    @BeforeEach
    void setUp() {
        repository.clear();
    }

    @Test
    void shouldAddFindSortAndRemoveArrays() {
        ArrayWrapper first = new ArrayWrapper(new BigInteger[]{BigInteger.TEN, BigInteger.ONE}, "first");
        ArrayWrapper second = new ArrayWrapper(new BigInteger[]{BigInteger.valueOf(3)}, "second");

        assertTrue(repository.add(first));
        assertTrue(repository.add(second));

        assertEquals(first, repository.findFirst(new NameSpecification("first")).orElseThrow());
        assertEquals(second, repository.findFirst(new NameSpecification("second")).orElseThrow());
        assertEquals(first, repository.sort(ArrayComparator.BY_NAME).get(0));
        assertEquals(first, repository.sort(ArrayComparator.BY_ELEMENT_COUNT).get(1));

        assertFalse(repository.add(new ArrayWrapper(new BigInteger[]{BigInteger.ZERO}, "first")));
        assertTrue(repository.remove(first));
        assertTrue(warehouse.get(first.getName()).isEmpty());
    }

    @Test
    void shouldUpdateWarehouseWhenArrayElementChanges() {
        ArrayWrapper arrayWrapper = new ArrayWrapper(new BigInteger[]{BigInteger.ONE, BigInteger.TWO}, "numbers");
        repository.add(arrayWrapper);

        assertEquals(BigInteger.valueOf(3), warehouse.get("numbers").orElseThrow().sum().orElseThrow());
        assertTrue(repository.findFirst(StatisticSpecification.sum(BigInteger.TWO, ComparisonType.GREATER)).isPresent());

        arrayWrapper.set(0, BigInteger.TEN);

        assertEquals(BigInteger.valueOf(12), warehouse.get("numbers").orElseThrow().sum().orElseThrow());
    }
}