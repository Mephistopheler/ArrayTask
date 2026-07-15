package org.example.arraytask.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.example.arraytask.entity.ArrayWrapper;
import org.example.arraytask.specification.ArraySpecification;
import org.example.arraytask.warehouse.ArrayWarehouse;
import org.example.arraytask.warehouse.ArrayWarehouseUpdater;

public class ArrayRepository {
    private static final ArrayRepository instance = new ArrayRepository();

    private final List<ArrayWrapper> arrays = new ArrayList<>();
    private final ArrayWarehouseUpdater warehouseUpdater = new ArrayWarehouseUpdater();

    private ArrayRepository() {
    }

    public static ArrayRepository getInstance() {
        return instance;
    }

    public boolean add(ArrayWrapper arrayWrapper) {
        boolean nameAlreadyExists = arrays.stream()
                .anyMatch(array -> array.getName().equals(arrayWrapper.getName()));
        if (nameAlreadyExists) {
            return false;
        }

        boolean added = arrays.add(arrayWrapper);
        if (added) {
            arrayWrapper.attach(warehouseUpdater);
            ArrayWarehouse.getInstance().put(arrayWrapper);
        }
        return added;
    }

    public boolean remove(ArrayWrapper arrayWrapper) {
        boolean removed = arrays.remove(arrayWrapper);
        if (removed) {
            arrayWrapper.detach(warehouseUpdater);
            ArrayWarehouse.getInstance().remove(arrayWrapper.getName());
        }
        return removed;
    }

    public Optional<ArrayWrapper> findFirst(ArraySpecification specification) {
        return arrays.stream()
                .filter(specification::specified)
                .findFirst();
    }

    public List<ArrayWrapper> findAll(ArraySpecification specification) {
        return arrays.stream()
                .filter(specification::specified)
                .toList();
    }

    public List<ArrayWrapper> sort(Comparator<ArrayWrapper> comparator) {
        return arrays.stream()
                .sorted(comparator)
                .toList();
    }

    public List<ArrayWrapper> getAll() {
        return List.copyOf(arrays);
    }

    public void clear() {
        arrays.forEach(array -> array.detach(warehouseUpdater));
        arrays.clear();
        ArrayWarehouse.getInstance().clear();
    }
}