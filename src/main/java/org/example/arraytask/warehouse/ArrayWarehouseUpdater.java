package org.example.arraytask.warehouse;

import org.example.arraytask.observer.ArrayEvent;
import org.example.arraytask.observer.ArrayObserver;

public class ArrayWarehouseUpdater implements ArrayObserver {
    @Override
    public void arrayChanged(ArrayEvent event) {
        ArrayWarehouse.getInstance().put(event.getSource());
    }
}